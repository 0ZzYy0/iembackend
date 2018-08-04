package com.iem.safety.iembackend.detaileismic;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface DetailSeismicRepository extends MongoRepository<DetailSeismic, String> {

    DetailSeismic findDetailSeismicByAssessId(String assessId);
}
