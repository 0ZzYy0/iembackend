package com.iem.safety.iembackend.lifeline;

import com.iem.safety.iembackend.expectenvir.Part;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author CHenXiaoTian 2018-09-03 15:24
 */

@RestController
@RequestMapping("LifeLine")
public class LifeLineController {

    private final LifeLineService service;
    private final LifeLineRepository repository;

    public LifeLineController(LifeLineService service, LifeLineRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @RequestMapping(value = "getByOidAndEid", method = RequestMethod.GET)
    public List<LifeLine> getByOidAndEid(@RequestParam("ownerId") String ownerId,
                                  @RequestParam("earthquakeId") String earthquakeId) throws IOException {
        return service.findByOwnerIdAndEarthquakeId(ownerId, earthquakeId);
    }

    @RequestMapping(value = "getMsfDome", method = RequestMethod.GET)
    public List<Part> getMsfDome() throws IOException {
        return service.getMsfDome();
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<LifeLine> saveAll(@RequestBody List<LifeLine> LifeLineList) {
        return repository.saveAll(LifeLineList);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteLifeLineById(id);
    }

}
