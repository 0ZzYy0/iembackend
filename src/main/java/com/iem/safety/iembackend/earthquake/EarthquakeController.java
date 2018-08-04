package com.iem.safety.iembackend.earthquake;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("earthquake")
@SuppressWarnings(value = "unused")
public class EarthquakeController {
    private final EarthquakeRepository repository;
    private final EarthquakeService service;

    public EarthquakeController(EarthquakeRepository repository, EarthquakeService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "findall", method = RequestMethod.GET)
    public List<Earthquake> findAll() {
        return repository.findAll();
    }


    @RequestMapping(value = "findallandgroup", method = RequestMethod.GET)
    public Map<String, Object> findAllAndGroup(@RequestParam("customerId") String customerId) {
        return service.findAllAndGroup(customerId);
    }


    @RequestMapping(value = "su/add", method = RequestMethod.POST)
    public Earthquake findAllAndGroup(@RequestBody Earthquake earthquake) {
        return repository.insert(earthquake);
    }

    @RequestMapping(value = "su/modify", method = RequestMethod.POST)
    public Earthquake modify(@RequestBody Earthquake earthquake) {
        return repository.save(earthquake);
    }
}
