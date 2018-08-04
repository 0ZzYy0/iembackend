package com.iem.safety.iembackend.detailpartinfo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface DetailPartInfoRepository extends MongoRepository<DetailPartInfo, String> {
    DetailPartInfo findDetailPartInfoByAssessIdAndStructurePartId(String assessId, String partId);
}
