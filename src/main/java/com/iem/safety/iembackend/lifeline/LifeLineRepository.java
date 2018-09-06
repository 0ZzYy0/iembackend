package com.iem.safety.iembackend.lifeline;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LifeLineRepository extends MongoRepository<LifeLine, String> {
    List<LifeLine> findByOwnerIdAndEarthquakeId(String ownerId, String earthquakeId);

    void deleteLifeLineById(String id);
}
