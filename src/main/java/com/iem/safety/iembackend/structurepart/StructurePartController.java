package com.iem.safety.iembackend.structurepart;

import com.iem.safety.iembackend.utils.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("StructurePart")
@SuppressWarnings(value = "unused")
public class StructurePartController {


    private final StructurePartRepository repository;
    private final StructurePartService service;


    public StructurePartController(StructurePartRepository repository, StructurePartService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<StructurePart> findAll() {
        return repository.findAll();

    }

    @RequestMapping(value = "su/findAllByFatherId", method = RequestMethod.GET)
    public List<StructurePart> findAllRecursiveByFatherId(@RequestParam("fid") String fid) {
        return service.findAllByFatherId(fid);
    }

    @RequestMapping(value = "getSubPartByAssessId", method = RequestMethod.GET)
    public Message getSubPartByAssessId(@RequestParam("assessId") String assessId) {
        return service.getSubPartByAssessId(assessId);
    }


    @RequestMapping(value = "getSubPartByFid", method = RequestMethod.GET)
    public List<StructurePart> getSubPartByFid(@RequestParam("fid") String fid) {
        return repository.findStructurePartsByFatherId(fid);
    }

    @RequestMapping(value = "su/delRecursiveById", method = RequestMethod.GET)
    public void delRecursiveById(@RequestParam("id") String id) {
        service.delRecursiveById(id);
    }


    @RequestMapping(value = "su/add", method = RequestMethod.POST)
    public StructurePart add(@RequestBody StructurePart part) {
        return repository.insert(part);
    }

    @RequestMapping(value = "su/addMulti", method = RequestMethod.POST)
    public List<StructurePart> addMulti(
            @RequestBody Map<String, Object> map) {
        return service.addMulti(map);
    }
}
