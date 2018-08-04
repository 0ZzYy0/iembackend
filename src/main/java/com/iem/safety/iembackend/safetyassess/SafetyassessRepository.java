package com.iem.safety.iembackend.safetyassess;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi 2018-05-04 15:58
 */
public interface SafetyassessRepository extends MongoRepository<Safetyassess, String> {


    Long deleteByUuid(String uuid);

    Safetyassess findSafetyassessByUuid(String uuid);

    Safetyassess findSafetyassessById(String id);

    List<Safetyassess> findSafetyassessesByOwnerIdAndEarthquakeId(String ownerId, String earthquakeId);
}
