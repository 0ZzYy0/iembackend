package com.iem.safety.iembackend.geologydisaster;

import com.iem.safety.iembackend.intensitysurvey.Intensitysurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zy 2018-05-04 16:01
 */
@RestController
@RequestMapping("geologydisaster")
@SuppressWarnings(value = "unused")
public class GeologyDisasterController {
//添加备注

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

    @RequestMapping(value = "getbyoidandeid", method = RequestMethod.GET)
    public List<GeologyDisaster> getByOidAndTSLg(@RequestParam("ownerId") String ownerId,
                                                 @RequestParam("earthquakeId") String earthquakeId) throws IOException {
        return repository.findByOwnerIdAndEarthquakeId(ownerId, earthquakeId);
    }

    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        repository.deleteGeologyDisasterById(id);
    }

    @RequestMapping(value = "admin/exportGeologyDisasterAll", method = RequestMethod.GET)
    public void exportGeologyDisasterAll(@RequestParam("eid") String eid,
                                     HttpServletResponse res) {
        service.exportGeologyDisasterAll(eid, res);
    }

    @RequestMapping(value = "admin/exportGeologyDisasterByGroup", method = RequestMethod.GET)
    public void exportGeologyDisasterByGroup(@RequestParam("eid") String eid,
                                             HttpServletResponse res) {
        service.exportGeologyDisasterByGroup(res, eid);
    }

    @RequestMapping(value = "customer/exportGeologyDisasterByEid", method = RequestMethod.GET)
    public void exportCustomerGeologyDisasterByEid(@RequestParam("eid") String eid,
                                               @RequestParam("cid") String cid,
                                               HttpServletResponse res) {
        service.exportCustomerGeologyDisasterByEid(eid, cid, res);
    }
}
