package com.iem.safety.iembackend.multisurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MengQi 2018-05-04 16:01
 */
@RestController
@RequestMapping("multisurvey")
@SuppressWarnings(value = "unused")
public class MultisurveyController {


    private final MultisurveyRepository repository;
    private final MultisurveyService service;

    @Autowired
    public MultisurveyController(MultisurveyRepository repository, MultisurveyService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<Multisurvey> saveAll(@RequestBody List<Multisurvey> lists) {
        return repository.saveAll(lists);
    }

    @RequestMapping(value = "insertone", method = RequestMethod.POST)
    public Multisurvey insertOne(@RequestBody Multisurvey multisurvey) {
        return repository.save(multisurvey);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteById(id);
    }

    @RequestMapping(value = "getbysuidandoid", method = RequestMethod.GET)
    public Multisurvey getBySurveyId(@RequestParam("surveyUuid") String surveyUuid,
                                     @RequestParam("ownerId") String ownerId) {
        return repository.findByOwnerIdAndSurveyUuid(ownerId, surveyUuid);
    }
}
