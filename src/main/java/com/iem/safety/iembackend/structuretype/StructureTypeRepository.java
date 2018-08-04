package com.iem.safety.iembackend.structuretype;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface StructureTypeRepository extends MongoRepository<StructureType, String> {
    StructureType findStructureTypeByTypeName(String typeName);

    StructureType findStructureTypeById(String id);
}
