package com.iem.safety.iembackend.earthquake;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface EarthquakeRepository extends MongoRepository<Earthquake, String> {
    Earthquake findEarthquakeById(String id);

}
