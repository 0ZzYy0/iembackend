package com.iem.safety.iembackend.safetyassess;

import com.iem.safety.iembackend.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-05-04 16:01
 */
@RestController
@RequestMapping("safetyassess")
@SuppressWarnings(value = "unused")
public class SafetyassessController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SafetyassessRepository repository;
    private final SafetyassessService service;

    public SafetyassessController(SafetyassessRepository repository, SafetyassessService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "getbyowneridandeid", method = RequestMethod.GET)
    public List<Map<String, String>> getByUserId(@RequestParam("ownerId") String ownerId,
                                                 @RequestParam("earthquakeId") String earthquakeId) {
        return service.getByUserId(ownerId, earthquakeId);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteById(id);
    }


    @RequestMapping(value = "getbyuuid", method = RequestMethod.GET)
    public Message getByUuid(@RequestParam("uuid") String uuid) {
        return service.getByUuid(uuid);

    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Safetyassess save(@RequestBody Safetyassess safetyassess) {
        return repository.save(safetyassess);
    }


}
