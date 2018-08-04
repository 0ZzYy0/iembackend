package com.iem.safety.iembackend.fileEntity;


import com.iem.safety.iembackend.normaladmin.NormalAdmin;
import com.iem.safety.iembackend.normaladmin.NormalAdminRepository;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author MengQi 2018-01-08 15:58
 */
@Service
@SuppressWarnings("unused")
public class FileEntityService {
    private final static String rootPath = System.getProperty("user.dir");
    private final static String fileDir = System.getProperty("user.dir") + File.separator + "static";
    private final static String REMOATEURL = "http://47.105.56.124";
    private final FileEntityRepository repository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final NormalAdminRepository adminRepository;


    @Autowired
    public FileEntityService(FileEntityRepository repository, NormalAdminRepository adminRepository) {
        this.repository = repository;

        this.adminRepository = adminRepository;
    }

    public Map<String, Object> upload(MultipartFile multipartFile, String id, String earthquakeId, String usage,int typeId) {
        String dir = fileDir + "/" + id;
        Map<String, Object> map = new HashMap<>();
        File dirFile = new File(dir);
        logger.info("dir:" + dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                map.put("errorMsg", "fail");
                return map;
            }
        }

        FileEntity fileEntity = new FileEntity();
        fileEntity.setHost(REMOATEURL);
        fileEntity.setEqId(earthquakeId);
        fileEntity.setCustomerId(id);
        fileEntity.setUsage(usage);
        fileEntity.setTypeId(typeId);
        fileEntity.setName(multipartFile.getOriginalFilename());
        fileEntity.setSize(multipartFile.getSize());
        fileEntity.setType(multipartFile.getContentType());

        fileEntity.setUri("/static/" + id + "/" + multipartFile.getOriginalFilename());
        File file = new File(dirFile + "/" + multipartFile.getOriginalFilename());

        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
            map.put("errorMsg", "ok");
            map.put("data", repository.save(fileEntity));
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("errorMsg", "fail");
            return map;
        }

    }

    public Map<String, Object> adminUpload(MultipartRequest request, String id) {
        String dir = fileDir + "/" + id;
        Map<String, Object> map = new HashMap<>();
        File dirFile = new File(dir);
        logger.info("dir:" + dir);
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                map.put("errorMsg", "fail");
                return map;
            }
        }

        MultiValueMap<String, MultipartFile> mfm = request.getMultiFileMap();
        Set<Map.Entry<String, List<MultipartFile>>> es = mfm.entrySet();
        List<String> list = new ArrayList<>();
        NormalAdmin admin = adminRepository.findNormalAdminById(id);
        for (Map.Entry<String, List<MultipartFile>> e : es) {
            List<MultipartFile> vs = e.getValue();
            for (MultipartFile multipartFile : vs) {
                FileEntity fileEntity = new FileEntity();
                fileEntity.setHost(REMOATEURL);
                fileEntity.setCustomerId(id);
                fileEntity.setEqId(admin.getEarthquakeId());
                fileEntity.setUsage("newsImage");
                fileEntity.setName(multipartFile.getOriginalFilename());
                fileEntity.setSize(multipartFile.getSize());
                fileEntity.setType(multipartFile.getContentType());

                fileEntity.setUri("/static/" + id + "/" + multipartFile.getOriginalFilename());
                File file = new File(dirFile + "/" + multipartFile.getOriginalFilename());
                list.add(REMOATEURL + "/static/" + id + "/" + multipartFile.getOriginalFilename());
                try {
                    FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }


        map.put("errno", 0);
        map.put("data", list);
        return map;

    }


    public void delById(String id) {
        FileEntity entity = repository.findFileEntityById(id);
        FileUtils.deleteQuietly(new File(rootPath + entity.getUri()));
        repository.delete(entity);
    }
}
