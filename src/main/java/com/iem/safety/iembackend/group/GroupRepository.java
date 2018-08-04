package com.iem.safety.iembackend.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface GroupRepository extends MongoRepository<Group, String> {

    List<Group> findGroupByCustomerId(String customerId);

    Group findGroupByCustomerIdAndEarthquakeId(String customerId, String earthquakeId);

    Page<Group> findGroupsByEarthquakeId(String earthquake, Pageable pageable);

    List<Group> findGroupsByEarthquakeId(String earthquake);

    List<Group> findGroupsByEarthquakeIdAndIsLeader(String earthquakeId, String isLeader);
}
