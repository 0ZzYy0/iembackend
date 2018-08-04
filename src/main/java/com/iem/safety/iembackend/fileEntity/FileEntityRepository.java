package com.iem.safety.iembackend.fileEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author MengQi 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface FileEntityRepository extends MongoRepository<FileEntity, String> {
    FileEntity findFileEntityById(String id);

    List<FileEntity> findFileEntitiesByEqId(String earthquakeId);

    List<FileEntity> findFileEntitiesByEqIdAndCustomerId(String earthquakeId,String customerId);

    List<FileEntity> findFileEntitiesByEqIdAndTypeId(String eqId,int typeId);
}
