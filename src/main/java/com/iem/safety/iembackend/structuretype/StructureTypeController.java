package com.iem.safety.iembackend.structuretype;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("StructureType")
@SuppressWarnings(value = "unused")
public class StructureTypeController {

    private final StructureTypeRepository repository;

    public StructureTypeController(StructureTypeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<StructureType> getByUuid() {
        return repository.findAll();

    }
}
