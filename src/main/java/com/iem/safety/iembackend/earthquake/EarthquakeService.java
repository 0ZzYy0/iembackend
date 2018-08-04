package com.iem.safety.iembackend.earthquake;

import com.iem.safety.iembackend.group.Group;
import com.iem.safety.iembackend.group.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class EarthquakeService {

    private final GroupRepository groupRepository;
    private final EarthquakeRepository repository;

    public EarthquakeService(GroupRepository groupRepository, EarthquakeRepository repository) {
        this.groupRepository = groupRepository;
        this.repository = repository;
    }

    public Map<String, Object> findAllAndGroup(String customerId) {
        Map<String, Object> map = new HashMap<>();

        List<Earthquake> earthquakes = repository.findAll();
        Earthquake earthquake = earthquakes.get(earthquakes.size() - 1);
        Group group = groupRepository.findGroupByCustomerIdAndEarthquakeId(customerId, earthquake.getId());
        if (group == null) group = new Group();
        map.put("group", group);
        map.put("earthquakes", earthquakes);
        return map;
    }
}
