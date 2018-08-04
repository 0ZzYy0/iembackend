package com.iem.safety.iembackend.fileEntity;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-01-08 15:58
 */
@RestController
@RequestMapping("fileentity")
@SuppressWarnings(value = "unused")
public class FileEntityController {

    private final FileEntityRepository repository;
    private final FileEntityService service;

    public FileEntityController(FileEntityRepository repository, FileEntityService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(@RequestParam("file") MultipartFile multipartFile,
                                      @RequestParam("id") String id,
                                      @RequestParam("eqId") String eqId,
                                      @RequestParam("usage") String usage,
                                      @RequestParam("typeId") int typeId) throws IOException {
        return service.upload(multipartFile, id, eqId, usage,typeId);
    }

    @RequestMapping(value = "admin/upload", method = RequestMethod.POST)
    public Map<String, Object> adminUpload(@RequestParam("id") String id,
                                           MultipartRequest request) throws IOException {
        return service.adminUpload(request, id);
    }


    @RequestMapping(value = "delbyid", method = RequestMethod.POST)
    public void delById(@RequestParam("id") String id) {
        service.delById(id);
    }


    @RequestMapping(value = "admin/getByTypeIdAndEQId", method = RequestMethod.GET)
    public List<FileEntity> getByTypeIdAndEQId(@RequestParam("eqId") String eqId,
            @RequestParam("typeId") int typeId)  {
        return repository.findFileEntitiesByEqIdAndTypeId(eqId,typeId);
    }

}
