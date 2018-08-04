package com.iem.safety.iembackend.expectenvir;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-06-20 15:25
 */
public interface ExpectEnvirRepository extends MongoRepository<ExpectEnvir, String> {
    ExpectEnvir findExpectEnvirByAssessId(String assessId);

}
