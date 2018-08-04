package com.iem.safety.iembackend.earthquake;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class Earthquake {
    @Id
    private String id;

    private String uuid;

    private String numbering;

    private String name;

    private String dateTime;

    private String deep;

    private String level;

    private String lat;

    private String lng;

    public Earthquake() {
    }

    public Earthquake(String id, String uuid, String numbering, String name, String dateTime, String deep, String level, String lat, String lng) {

        this.id = id;
        this.uuid = uuid;
        this.numbering = numbering;
        this.name = name;
        this.dateTime = dateTime;
        this.deep = deep;
        this.level = level;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


}
