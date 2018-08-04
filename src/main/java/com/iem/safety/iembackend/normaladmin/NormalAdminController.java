package com.iem.safety.iembackend.normaladmin;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MengQi 2018-06-05 21:32
 */
@RestController
@RequestMapping("normaladmin")
@SuppressWarnings(value = "unused")
public class NormalAdminController {


    private final NormalAdminRepository repository;

    private final NormalAdminService service;

    public NormalAdminController(NormalAdminRepository repository, NormalAdminService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "su/add", method = RequestMethod.POST)
    public NormalAdmin add(@RequestBody NormalAdmin NormalAdmin) {
        return repository.insert(NormalAdmin);
    }

    @RequestMapping(value = "su/findbyeid", method = RequestMethod.GET)
    public List<NormalAdmin> add(@RequestParam("eid") String eid) {
        return repository.findNormalAdminsByEarthquakeId(eid);
    }


}
