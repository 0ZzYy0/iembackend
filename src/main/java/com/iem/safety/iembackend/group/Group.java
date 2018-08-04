package com.iem.safety.iembackend.group;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class Group {
    @Id
    private String id;

    private String earthquakeId;

    private String numbering;

    private String groupNumbering;

    private String name;

    private String role;

    private String customerId;

    private String isLeader;


    public Group(String id, String earthquakeId, String numbering, String groupNumbering, String name, String role, String customerId, String isLeader) {
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.numbering = numbering;
        this.groupNumbering = groupNumbering;
        this.name = name;
        this.role = role;
        this.customerId = customerId;
        this.isLeader = isLeader;
    }

    public Group() {
    }

    public Group(String id, String earthquakeId, String numbering, String groupNumbering, String name, String role, String customerId) {
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.numbering = numbering;
        this.groupNumbering = groupNumbering;
        this.name = name;
        this.role = role;
        this.customerId = customerId;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public String getGroupNumbering() {
        return groupNumbering;
    }

    public void setGroupNumbering(String groupNumbering) {
        this.groupNumbering = groupNumbering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
