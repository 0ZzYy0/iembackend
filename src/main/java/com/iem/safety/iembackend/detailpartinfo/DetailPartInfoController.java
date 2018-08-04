package com.iem.safety.iembackend.detailpartinfo;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("DetailPartInfo")
@SuppressWarnings(value = "unused")
public class DetailPartInfoController {
    private final DetailPartInfoRepository repository;
    private final DetailPartInfoService service;

    public DetailPartInfoController(DetailPartInfoRepository repository, DetailPartInfoService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "getByAssessIdAndPartId", method = RequestMethod.GET)
    public DetailPartInfo getSubPartByFid(@RequestParam("partId") String partId,
                                          @RequestParam("assessId") String assessId) {
        return service.getSubPartByFid(assessId, partId);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public DetailPartInfo saveAll(@RequestBody DetailPartInfo DetailPartInfo) throws IOException {
        return repository.save(DetailPartInfo);
    }
}
