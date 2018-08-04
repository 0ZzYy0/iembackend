package com.iem.safety.iembackend.singlesurvey;

import com.iem.safety.iembackend.safetyassess.SafetyassessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MengQi 2018-05-04 16:01
 */
@RestController
@RequestMapping("singlesurvey")
@SuppressWarnings(value = "unused")
public class SinglesurveyController {


    private final SinglesurveyRepository repository;
    private final SafetyassessRepository safetyassessRepository;
    private final SinglesurveyService service;

    @Autowired
    public SinglesurveyController(SinglesurveyRepository repository, SafetyassessRepository safetyassessRepository, SinglesurveyService service) {
        this.repository = repository;
        this.safetyassessRepository = safetyassessRepository;
        this.service = service;
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<Singlesurvey> saveAll(@RequestBody List<Singlesurvey> lists) {
        return repository.saveAll(lists);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteById(id);
    }

    @RequestMapping(value = "getbysurveyid", method = RequestMethod.GET)
    public List<Singlesurvey> getBySurveyId(@RequestParam("surveyId") String surveyId,
                                            @RequestParam("ownerId") String ownerId) {
        return repository.findByOwnerIdAndSurveyId(ownerId, surveyId);
    }


    @RequestMapping(value = "getbysurveyuuid", method = RequestMethod.GET)
    public List<Singlesurvey> getBySurveyUuid(@RequestParam("surveyUuid") String surveyUuid,
                                              @RequestParam("ownerId") String ownerId) {
        return repository.findByOwnerIdAndSurveyUuid(ownerId, surveyUuid);
    }
}
