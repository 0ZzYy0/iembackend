package com.iem.safety.iembackend.intensitysurvey;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 烈度调查
 *
 * @author MengQi 2018-05-04 15:50
 */
@SuppressWarnings(value = "unused")
public class Intensitysurvey {

    @Id
    private String id;

    private String altitude;

    private String uuid;

    private String ownerId;

    private String openId;

    private String name;

    private String address;

    private String lat;

    private String lng;

    private String dateTime;

    private long timestamp;

    private String mark;

    private String intensity;

    private String status;

    private String houseNumber;

    private String avgArea;

    private String totalPeople;

    private String death;

    private String miss;

    private String severeWound;

    private String slightWound;
    private String earthquakeId;

    private String fileType = "image";


    private List<String> images;
    private List<String> videos;
    private List<String> audios;

    private List<FileEntity> imageList;
    private List<FileEntity> videoList;
    private List<FileEntity> audioList;

    public Intensitysurvey(String id, String altitude, String uuid, String ownerId, String openId, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String intensity, String status, String houseNumber, String avgArea, String totalPeople, String death, String miss, String severeWound, String slightWound, String earthquakeId, String fileType, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList) {
        this.id = id;
        this.altitude = altitude;
        this.uuid = uuid;
        this.ownerId = ownerId;
        this.openId = openId;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.dateTime = dateTime;
        this.timestamp = timestamp;
        this.mark = mark;
        this.intensity = intensity;
        this.status = status;
        this.houseNumber = houseNumber;
        this.avgArea = avgArea;
        this.totalPeople = totalPeople;
        this.death = death;
        this.miss = miss;
        this.severeWound = severeWound;
        this.slightWound = slightWound;
        this.earthquakeId = earthquakeId;
        this.fileType = fileType;
        this.images = images;
        this.videos = videos;
        this.audios = audios;
        this.imageList = imageList;
        this.videoList = videoList;
        this.audioList = audioList;
    }

    public Intensitysurvey() {
        super();
    }

    public Intensitysurvey(String id, String altitude, String uuid, String ownerId, String openId, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String intensity, String status, String houseNumber, String avgArea, String totalPeople, String death, String miss, String severeWound, String slightWound, String earthquakeId) {

        this.id = id;
        this.altitude = altitude;
        this.uuid = uuid;
        this.ownerId = ownerId;
        this.openId = openId;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.dateTime = dateTime;
        this.timestamp = timestamp;
        this.mark = mark;
        this.intensity = intensity;
        this.status = status;
        this.houseNumber = houseNumber;
        this.avgArea = avgArea;
        this.totalPeople = totalPeople;
        this.death = death;
        this.miss = miss;
        this.severeWound = severeWound;
        this.slightWound = slightWound;
        this.earthquakeId = earthquakeId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<String> getAudios() {
        return audios;
    }

    public void setAudios(List<String> audios) {
        this.audios = audios;
    }

    public List<FileEntity> getImageList() {
        return imageList;
    }

    public void setImageList(List<FileEntity> imageList) {
        this.imageList = imageList;
    }

    public List<FileEntity> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<FileEntity> videoList) {
        this.videoList = videoList;
    }

    public List<FileEntity> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<FileEntity> audioList) {
        this.audioList = audioList;
    }

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getMiss() {
        return miss;
    }

    public void setMiss(String miss) {
        this.miss = miss;
    }

    public String getSevereWound() {
        return severeWound;
    }

    public void setSevereWound(String severeWound) {
        this.severeWound = severeWound;
    }

    public String getSlightWound() {
        return slightWound;
    }

    public void setSlightWound(String slightWound) {
        this.slightWound = slightWound;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAvgArea() {
        return avgArea;
    }

    public void setAvgArea(String avgArea) {
        this.avgArea = avgArea;
    }

    public String getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(String totalPeople) {
        this.totalPeople = totalPeople;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
