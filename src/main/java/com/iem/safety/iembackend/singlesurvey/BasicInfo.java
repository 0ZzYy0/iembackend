package com.iem.safety.iembackend.singlesurvey;

import com.iem.safety.iembackend.fileEntity.FileEntity;

import java.util.List;

/**
 * @author MengQi 2018-05-09 16:43
 */
public class BasicInfo {


    private String uuid;

    private String surveyId;

    private String surveyUuid;

    private String ownerId;

    private String openId;

    private String houseHost;
    private boolean fortified;//是否抗震设防

    private String regionParam;//参数地区选择
    private String name;
    private String address;
    private String lat;
    private String lng;
    private String dateTime;
    private long timestamp;
    private String mark;
    private String area;
    private String status;
    private String damage;
    private String areaType = "";
    private String structType;
    private String usage;
    private String kangZhen;
    private String fileType;
    private boolean assessed = false;
    private List<String> images;
    private List<String> videos;
    private List<String> audios;
    private List<FileEntity> imageList;
    private List<FileEntity> videoList;
    private List<FileEntity> audioList;

    public BasicInfo(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String houseHost, boolean fortified, String regionParam, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList) {
        this.uuid = uuid;
        this.surveyId = surveyId;
        this.surveyUuid = surveyUuid;
        this.ownerId = ownerId;
        this.openId = openId;
        this.houseHost = houseHost;
        this.fortified = fortified;
        this.regionParam = regionParam;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.dateTime = dateTime;
        this.timestamp = timestamp;
        this.mark = mark;
        this.area = area;
        this.status = status;
        this.damage = damage;
        this.areaType = areaType;
        this.structType = structType;
        this.usage = usage;
        this.kangZhen = kangZhen;
        this.fileType = fileType;
        this.assessed = assessed;
        this.images = images;
        this.videos = videos;
        this.audios = audios;
        this.imageList = imageList;
        this.videoList = videoList;
        this.audioList = audioList;
    }

    public BasicInfo() {
        super();
    }

    public BasicInfo(BasicInfo basicInfo) {
        this.uuid = basicInfo.uuid;
        this.surveyId = basicInfo.surveyId;
        this.surveyUuid = basicInfo.surveyUuid;
        this.ownerId = basicInfo.ownerId;
        this.openId = basicInfo.openId;
        this.name = basicInfo.name;
        this.address = basicInfo.address;
        this.lat = basicInfo.lat;
        this.lng = basicInfo.lng;
        this.dateTime = basicInfo.dateTime;
        this.timestamp = basicInfo.timestamp;
        this.mark = basicInfo.mark;
        this.area = basicInfo.area;
        this.status = basicInfo.status;
        this.damage = basicInfo.damage;
        this.areaType = basicInfo.areaType;
        this.structType = basicInfo.structType;
        this.usage = basicInfo.usage;
        this.kangZhen = basicInfo.kangZhen;
        this.fileType = basicInfo.fileType;
        this.assessed = basicInfo.assessed;
        this.images = basicInfo.images;
        this.videos = basicInfo.videos;
        this.audios = basicInfo.audios;
        this.imageList = basicInfo.imageList;
        this.videoList = basicInfo.videoList;
        this.audioList = basicInfo.audioList;
        this.regionParam = basicInfo.regionParam;
        this.fortified = basicInfo.fortified;
        this.houseHost = basicInfo.houseHost;
    }

    public String getRegionParam() {
        return regionParam;
    }

    public void setRegionParam(String regionParam) {
        this.regionParam = regionParam;
    }

    public boolean isFortified() {
        return fortified;
    }

    public void setFortified(boolean fortified) {
        this.fortified = fortified;
    }

    public String getHouseHost() {
        return houseHost;
    }

//    public BasicInfo(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList) {
//
//        this.uuid = uuid;
//        this.surveyId = surveyId;
//        this.surveyUuid = surveyUuid;
//        this.ownerId = ownerId;
//        this.openId = openId;
//        this.name = name;
//        this.address = address;
//        this.lat = lat;
//        this.lng = lng;
//        this.dateTime = dateTime;
//        this.timestamp = timestamp;
//        this.mark = mark;
//        this.area = area;
//        this.status = status;
//        this.damage = damage;
//        this.areaType = areaType;
//        this.structType = structType;
//        this.usage = usage;
//        this.kangZhen = kangZhen;
//        this.fileType = fileType;
//        this.assessed = assessed;
//        this.images = images;
//        this.videos = videos;
//        this.audios = audios;
//        this.imageList = imageList;
//        this.videoList = videoList;
//        this.audioList = audioList;
//    }

    public void setHouseHost(String houseHost) {
        this.houseHost = houseHost;
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public boolean isAssessed() {
        return assessed;
    }

    public void setAssessed(boolean assessed) {
        this.assessed = assessed;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getSurveyUuid() {
        return surveyUuid;
    }

    public void setSurveyUuid(String surveyUuid) {
        this.surveyUuid = surveyUuid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getStructType() {
        return structType;
    }

    public void setStructType(String structType) {
        this.structType = structType;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getKangZhen() {
        return kangZhen;
    }

    public void setKangZhen(String kangZhen) {
        this.kangZhen = kangZhen;
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


}
