package com.iem.safety.iembackend.structurepart;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-06-20 21:29
 */
public class StructurePart {
    @Id
    private String id;

    private String partType;

    private String partName;

    private String fatherName;
    private String typeName;
    private String fatherId;
    private int level;

    public StructurePart(String id, String partType, String partName, String fatherName, String typeName, String fatherId, int level) {
        this.id = id;
        this.partType = partType;
        this.partName = partName;
        this.fatherName = fatherName;
        this.typeName = typeName;
        this.fatherId = fatherId;
        this.level = level;
    }

    public StructurePart(String id, String partType, String partName, String fatherName, String fatherId, int level) {
        this.id = id;
        this.partType = partType;
        this.partName = partName;
        this.fatherName = fatherName;
        this.fatherId = fatherId;
        this.level = level;
    }

    public StructurePart() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

}
