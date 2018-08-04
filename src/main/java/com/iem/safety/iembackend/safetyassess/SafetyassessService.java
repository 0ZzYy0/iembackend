package com.iem.safety.iembackend.safetyassess;


import com.iem.safety.iembackend.buildingsusage.BuildingUsage;
import com.iem.safety.iembackend.buildingsusage.BuildingUsageRepository;
import com.iem.safety.iembackend.singlesurvey.Singlesurvey;
import com.iem.safety.iembackend.singlesurvey.SinglesurveyRepository;
import com.iem.safety.iembackend.structuretype.StructureType;
import com.iem.safety.iembackend.structuretype.StructureTypeRepository;
import com.iem.safety.iembackend.utils.Message;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-01-08 15:58
 */
@Service
public class SafetyassessService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SafetyassessRepository repository;
    private final SinglesurveyRepository singlesurveyRepository;
    private final BuildingUsageRepository buildingUsageRepository;
    private final StructureTypeRepository structureTypeRepository;

    public SafetyassessService(SafetyassessRepository repository, SinglesurveyRepository singlesurveyRepository, BuildingUsageRepository buildingUsageRepository, StructureTypeRepository structureTypeRepository) {
        this.repository = repository;
        this.singlesurveyRepository = singlesurveyRepository;
        this.buildingUsageRepository = buildingUsageRepository;
        this.structureTypeRepository = structureTypeRepository;
    }

    List<Map<String, String>> getByUserId(String ownerId, String earthquakeId) {

        List<Map<String, String>> list = new ArrayList<>();

        List<Safetyassess> safetyassessList = repository.findSafetyassessesByOwnerIdAndEarthquakeId(ownerId, earthquakeId);

        List<Singlesurvey> singlesurveys = singlesurveyRepository.findByOwnerIdAndAssessedAndEarthquakeId(ownerId, false, earthquakeId);

        List<Safetyassess> newSFA = new ArrayList<>();
        for (Singlesurvey singlesurvey : singlesurveys) {
            singlesurvey.setAssessed(true);
            Safetyassess safetyassess = new Safetyassess(singlesurvey, new ObjectId().toString());
            safetyassess.setEarthquakeId(singlesurvey.getEarthquakeId());
            newSFA.add(safetyassess);
        }

        singlesurveyRepository.saveAll(singlesurveys);

        safetyassessList.addAll(repository.saveAll(newSFA));

        safetyassessList.forEach(safetyassess -> {
            Map<String, String> map = new HashMap<>();
            map.put("name", safetyassess.getName());
            map.put("id", safetyassess.getId());
            map.put("earthquakeId", safetyassess.getEarthquakeId());
            map.put("uuid", safetyassess.getUuid());
            list.add(map);
        });

        return list;

    }

    public Message getByUuid(String uuid) {
        Safetyassess safetyassess = repository.findSafetyassessByUuid(uuid);
        List<BuildingUsage> usages = buildingUsageRepository.findAll();
        List<StructureType> types = structureTypeRepository.findAll();
        Message message = new Message();
        message.setCode(1);
        message.setMsg("SUCCESS");
        Map<String, Object> map = new HashMap<>();
        map.put("types", types);
        map.put("usages", usages);
        map.put("assess", safetyassess);
        message.setResult(map);
        return message;
    }
}
