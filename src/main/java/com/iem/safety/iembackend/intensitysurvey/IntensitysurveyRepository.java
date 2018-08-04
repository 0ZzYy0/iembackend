package com.iem.safety.iembackend.intensitysurvey;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi 2018-05-04 15:58
 */
public interface IntensitysurveyRepository extends MongoRepository<Intensitysurvey, String> {

    void deleteIntensitysurveyById(String id);

    List<Intensitysurvey> findByOwnerIdAndTimestampGreaterThan(String ownerId, long timestamp);

    List<Intensitysurvey> findByOwnerIdAndEarthquakeId(String ownerId, String earthquakeId);

    List<Intensitysurvey> findIntensitysurveysByEarthquakeIdAndOwnerIdAndStatus(String earthquakeId, String customerId, String status);

    List<Intensitysurvey> findIntensitysurveysByEarthquakeIdAndStatus(String earthquakeId, String status);

}
