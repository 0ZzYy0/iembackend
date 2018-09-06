package com.iem.safety.iembackend.lifelineMonomers;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("lifeLineMonomers")
public class LifeLineMonomersController {

    private final LifeLineMonomersRepository repository;

    public LifeLineMonomersController(LifeLineMonomersRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "getByMIdAndEid", method = RequestMethod.GET)
    public List<LifeLineMonomers> getByMIdAndEid(@RequestParam("mId") String mId,
                                                 @RequestParam("earthquakeId") String earthquakeId) throws IOException {
        return repository.findByMIdAndEarthquakeId(mId, earthquakeId);
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<LifeLineMonomers> saveAll(@RequestBody List<LifeLineMonomers> LifeLineMonomersList) {
        return repository.saveAll(LifeLineMonomersList);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteLifeLineMonomersById(id);
    }

}
