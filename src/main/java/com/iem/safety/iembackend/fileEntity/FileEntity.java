package com.iem.safety.iembackend.fileEntity;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-07 21:38
 */
@SuppressWarnings("unused")
public class FileEntity {

    @Id
    private String id;
    private String host;
    private long size;//大小 单位 B
    private String uri;
    private String name;
    private String path;
    private String type;
    private String customerId;
    private String eqId;
    private int typeId;//1-image  2-video  3-audio
    private String usage;

    public FileEntity(String id, String host, long size, String uri, String name, String path, String type, String customerId, String eqId, int typeId, String usage) {
        this.id = id;
        this.host = host;
        this.size = size;
        this.uri = uri;
        this.name = name;
        this.path = path;
        this.type = type;
        this.customerId = customerId;
        this.eqId = eqId;
        this.typeId = typeId;
        this.usage = usage;
    }

    FileEntity() {
        super();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
