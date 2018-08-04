package com.iem.safety.iembackend.intensitysurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author MengQi 2018-05-04 16:01
 */
@RestController
@RequestMapping("intensitysurvey")
@SuppressWarnings(value = "unused")
public class IntensitysurveyController {


    private final IntensitysurveyRepository repository;
    private final IntensitysurveyService service;

    @Autowired
    public IntensitysurveyController(IntensitysurveyRepository repository, IntensitysurveyService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "saveall", method = RequestMethod.POST)
    public List<Intensitysurvey> saveAll(@RequestBody List<Intensitysurvey> lists) throws IOException {
        return repository.saveAll(lists);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteIntensitysurveyById(id);
    }

    @RequestMapping(value = "getbyoidandeid", method = RequestMethod.GET)
    public List<Intensitysurvey> getByOidAndTSLg(@RequestParam("ownerId") String ownerId,
                                                 @RequestParam("earthquakeId") String earthquakeId) throws IOException {
        return repository.findByOwnerIdAndEarthquakeId(ownerId, earthquakeId);
    }


    @RequestMapping(value = "getByEidForMap", method = RequestMethod.GET)
    public List<Intensitysurvey> getByEidForMap(@RequestParam("eid") String eid) throws IOException {
        return service.getByEidForMap(eid);
    }


    @RequestMapping(value = "admin/exportIntensitySurveyAll", method = RequestMethod.GET)
    public void exportIntensitySurveyAll(@RequestParam("eid") String eid,
                                         HttpServletResponse res) {
        service.exportIntensitySurveyAll(res, eid);
    }


    @RequestMapping(value = "admin/exportMultiSurveyAll", method = RequestMethod.GET)
    public void exportMultiSurveyAll(@RequestParam("eid") String eid,
                                     HttpServletResponse res) {
        service.exportMultiSurveyAll(eid, res);
    }


    @RequestMapping(value = "admin/exportIntensitySurveyByGroup", method = RequestMethod.GET)
    public void exportIntensitySurveyByGroup(@RequestParam("eid") String eid,
                                             HttpServletResponse res) {
        service.exportIntensitySurveyByGroup(res, eid);
    }


    @RequestMapping(value = "admin/exportMultiSurveyByGroup", method = RequestMethod.GET)
    public void exportMultiSurveyByGroup(@RequestParam("eid") String eid,
                                         HttpServletResponse res) {
        service.exportMultiSurveyByGroup(eid, res);
    }

    @RequestMapping(value = "customer/exportIntensitySurveyByEid", method = RequestMethod.GET)
    public void exportByEid(@RequestParam("eid") String eid,
                            @RequestParam("cid") String cid,
                            HttpServletResponse res) {
        service.exportCustomerByEid(eid, cid, res);
    }


    @RequestMapping(value = "customer/exportMultiSurveyByEid", method = RequestMethod.GET)
    public void exportCustomerMultiSurveyByEid(@RequestParam("eid") String eid,
                                               @RequestParam("cid") String cid,
                                               HttpServletResponse res) {
        service.exportCustomerMultiSurveyByEid(eid, cid, res);
    }
}
