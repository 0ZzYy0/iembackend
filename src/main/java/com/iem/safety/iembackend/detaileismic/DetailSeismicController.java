package com.iem.safety.iembackend.detaileismic;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("DetailSeismic")
@SuppressWarnings(value = "unused")
public class DetailSeismicController {

    private final DetailSeismicRepository repository;

    public DetailSeismicController(DetailSeismicRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public DetailSeismic saveAll(@RequestBody DetailSeismic detailSeismic) throws IOException {
        return repository.save(detailSeismic);
    }
}
