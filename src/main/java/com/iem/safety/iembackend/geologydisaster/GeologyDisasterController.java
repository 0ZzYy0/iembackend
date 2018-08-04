package com.iem.safety.iembackend.geologydisaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author zy 2018-05-04 16:01
 */
@RestController
@RequestMapping("geologydisaster")
@SuppressWarnings(value = "unused")
public class GeologyDisasterController {


    private final GeologyDisasterRepository repository;
    private final GeologyDisasterService service;

    @Autowired
    public GeologyDisasterController(GeologyDisasterRepository repository, GeologyDisasterService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<GeologyDisaster> saveAll(@RequestBody List<GeologyDisaster> lists) throws IOException {
        return repository.saveAll(lists);
    }

}
