package com.iem.safety.iembackend.detailpartinfo;

import com.iem.safety.iembackend.safetyassess.SafetyassessRepository;
import com.iem.safety.iembackend.structurepart.StructurePartRepository;
import com.iem.safety.iembackend.structuretype.StructureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class DetailPartInfoService {
    private final DetailPartInfoRepository repository;
    private final StructureTypeRepository structureTypeRepository;
    private final StructurePartRepository partRepository;
    private final SafetyassessRepository safetyassessRepository;

    public DetailPartInfoService(DetailPartInfoRepository repository, StructureTypeRepository structureTypeRepository, StructurePartRepository partRepository, SafetyassessRepository safetyassessRepository) {
        this.repository = repository;
        this.structureTypeRepository = structureTypeRepository;
        this.partRepository = partRepository;
        this.safetyassessRepository = safetyassessRepository;
    }

    public DetailPartInfo getSubPartByFid(String assessId, String partId) {
        DetailPartInfo partInfo = repository.findDetailPartInfoByAssessIdAndStructurePartId(assessId, partId);
        if (partInfo == null) {
            partInfo = new DetailPartInfo();
            partInfo.setAssessId(assessId);
            partInfo.setStructurePartId(partId);
            partInfo.setDamaged(false);
            partInfo.setCustomerId(safetyassessRepository.findSafetyassessById(assessId).getOwnerId());
            partInfo.setPartTypeName(partRepository.findStructurePartById(partId).getTypeName());
            partInfo.setDamages(new ArrayList<>());
            partInfo = repository.insert(partInfo);
        }
        return partInfo;
    }
}
