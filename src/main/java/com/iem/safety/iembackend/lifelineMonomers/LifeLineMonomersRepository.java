package com.iem.safety.iembackend.lifelineMonomers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LifeLineMonomersRepository extends MongoRepository<LifeLineMonomers, String> {

    List<LifeLineMonomers> findByMIdAndEarthquakeId(String mId, String earthquakeId);

    void deleteLifeLineMonomersById(String id);

}
