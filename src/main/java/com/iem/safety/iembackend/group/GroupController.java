package com.iem.safety.iembackend.group;

import com.iem.safety.iembackend.earthquake.Earthquake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("group")
@SuppressWarnings(value = "unused")
public class GroupController {
    private final GroupRepository repository;
    private final GroupService service;


    @Autowired
    public GroupController(GroupRepository repository, GroupService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "join", method = RequestMethod.POST)
    public Group join(@RequestBody Group group) {
        return repository.save(group);
    }


    @RequestMapping(value = "getbycustomerid", method = RequestMethod.GET)
    public List<Group> getByCustomerId(@RequestParam("customerId") String customerId) {
        return service.getByCustomerId(customerId);
    }

    @RequestMapping(value = "findbyeidandcustomerid", method = RequestMethod.GET)
    public Group findByEidAndCustomerId(@RequestParam("customerId") String customerId,
                                        @RequestParam("eid") String eid) {
        return repository.findGroupByCustomerIdAndEarthquakeId(customerId, eid);
    }

    @RequestMapping(value = "findmyeq", method = RequestMethod.GET)
    public List<Earthquake> findMyEQ(@RequestParam("customerId") String customerId) {
        return service.findMyEQ(customerId);
    }
}
