package com.iem.safety.iembackend.structurepart;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface StructurePartRepository extends MongoRepository<StructurePart, String> {
    StructurePart findStructurePartByTypeName(String typeName);

    StructurePart findStructurePartById(String id);

    int countAllByFatherId(String fatherId);

    List<StructurePart> findStructurePartsByFatherId(String fatherId);
}
