package com.iem.safety.iembackend.structurepart;

import com.iem.safety.iembackend.detaileismic.DetailSeismic;
import com.iem.safety.iembackend.detaileismic.DetailSeismicRepository;
import com.iem.safety.iembackend.safetyassess.Safetyassess;
import com.iem.safety.iembackend.safetyassess.SafetyassessRepository;
import com.iem.safety.iembackend.structuretype.StructureType;
import com.iem.safety.iembackend.structuretype.StructureTypeRepository;
import com.iem.safety.iembackend.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class StructurePartService {
    private final StructurePartRepository repository;
    private final SafetyassessRepository safetyassessRepository;
    private final StructureTypeRepository typeRepository;
    private final DetailSeismicRepository seismicRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public StructurePartService(StructurePartRepository repository, SafetyassessRepository safetyassessRepository, StructureTypeRepository typeRepository, DetailSeismicRepository seismicRepository) {
        this.repository = repository;
        this.safetyassessRepository = safetyassessRepository;
        this.typeRepository = typeRepository;
        this.seismicRepository = seismicRepository;
    }

    public List<StructurePart> addMulti(Map<String, Object> map) {
        String fId = (String) map.get("fatherId");
        int level = (int) map.get("fatherLevel") + 1;
        StructurePart fp = null;
        if (level > 1) fp = repository.findStructurePartById(fId);
        int c = repository.countAllByFatherId(fId);

        String[] partNames = ((String) map.get("partTypeNames")).split("#");
        List<StructurePart> list = new ArrayList<>();
        for (String partName : partNames) {
            if (partName.equals("")) continue;
            StructurePart part = new StructurePart();
            part.setFatherId(fId);
            part.setFatherName((String) map.get("fatherName"));
            part.setLevel(level);
            part.setTypeName(partName);
            part.setPartName(partName);
            StringBuilder ll = new StringBuilder();
            if (fp == null)
                ll.append(++c).append(".");
            else ll.append(fp.getPartType()).append(++c).append(".");
            part.setPartType(ll.toString());
            list.add(repository.insert(part));
        }

        return list;
    }


    private void recursiveFindAllByFatherId(String fatherId, List<StructurePart> list) {
        List<StructurePart> res = repository.findStructurePartsByFatherId(fatherId);
        if (res == null) return;
        for (StructurePart re : res) {
            list.add(re);
            System.out.println(re.getId());
            recursiveFindAllByFatherId(re.getId(), list);
        }
    }

    public List<StructurePart> findAllByFatherId(String fid) {
        List<StructurePart> list = new ArrayList<>();

        recursiveFindAllByFatherId(fid, list);
        return list;
    }

    public Message getSubPartByAssessId(String assessId) {
        Safetyassess assess = safetyassessRepository.findSafetyassessById(assessId);
        DetailSeismic detailSeismic = seismicRepository.findDetailSeismicByAssessId(assessId);
        if (detailSeismic == null) {
            detailSeismic = new DetailSeismic();
            detailSeismic.setAssessId(assessId);
            detailSeismic.setCustomerId(assess.getOwnerId());
            detailSeismic.setIntuited(true);
            detailSeismic.setIntuitJudgement("");
            detailSeismic = seismicRepository.insert(detailSeismic);
        }

        StructureType tp = typeRepository.findStructureTypeByTypeName(assess.getStructType());
        Message message = new Message();
        message.setCode(1);
        Map<String, Object> map = new HashMap<>();
        message.setResult(map);
        map.put("detailSeismic", detailSeismic);
        map.put("parts", repository.findStructurePartsByFatherId(tp.getId()));

        return message;
    }

    public void delRecursiveById(String id) {
        StructurePart res = repository.findStructurePartById(id);
        if (res == null) {
            return;
        } else {
            repository.delete(res);
        }
        List<StructurePart> list = repository.findStructurePartsByFatherId(res.getId());
        for (StructurePart part : list) {
            delRecursiveById(part.getId());
        }
    }
}
