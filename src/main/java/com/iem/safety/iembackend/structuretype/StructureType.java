package com.iem.safety.iembackend.structuretype;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class StructureType {
    @Id
    private String id;

    private String typeName;

    private int level = 0;

    public StructureType(String id, String typeName, int level) {
        this.id = id;
        this.typeName = typeName;
        this.level = level;
    }

    public StructureType() {
    }

    public StructureType(String id, String typeName) {
        this.id = id;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
