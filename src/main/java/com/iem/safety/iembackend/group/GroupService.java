package com.iem.safety.iembackend.group;

import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.Earthquake;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class GroupService {


    private final CustomerRepository customerRepository;
    private final EarthquakeRepository earthquakeRepository;

    private final GroupRepository repository;

    public GroupService(CustomerRepository customerRepository, EarthquakeRepository earthquakeRepository, GroupRepository repository) {
        this.customerRepository = customerRepository;
        this.earthquakeRepository = earthquakeRepository;
        this.repository = repository;
    }


    public Group join(Group group) {
        return repository.save(group);
    }

    public List<Group> getByCustomerId(String customerId) {
        return repository.findGroupByCustomerId(customerId);
    }

    public List<Earthquake> findMyEQ(String customerId) {
        List<Group> groups = repository.findGroupByCustomerId(customerId);
        List<Earthquake> list = new ArrayList<>();
        for (Group group : groups) {
            Earthquake eq = earthquakeRepository.findEarthquakeById(group.getEarthquakeId());
            list.add(eq);
        }

        return list;
    }
}
