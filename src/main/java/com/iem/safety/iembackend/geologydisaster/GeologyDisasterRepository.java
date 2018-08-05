package com.iem.safety.iembackend.geologydisaster;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zy 2018-05-04 15:58
 */
public interface GeologyDisasterRepository extends MongoRepository<GeologyDisaster, String> {

    void deleteGeologyDisasterById(String id);

    //List<GeologyDisaster> findByOwnerIdAndTimestampGreaterThan(String ownerId, long timestamp);

    List<GeologyDisaster> findByOwnerIdAndEarthquakeId(String ownerId, String earthquakeId);

    //List<GeologyDisaster> findGeologyDisasterByEarthquakeIdAndOwnerIdAndStatus(String earthquakeId, String customerId, String status);

    //List<GeologyDisaster> findGeologyDisasterByEarthquakeIdAndStatus(String earthquakeId, String status);

}
