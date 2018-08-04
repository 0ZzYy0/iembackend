package com.iem.safety.iembackend.buildingsusage;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface BuildingUsageRepository extends MongoRepository<BuildingUsage, String> {
    BuildingUsage findBuildingUsageByUsage(String usage);
}
