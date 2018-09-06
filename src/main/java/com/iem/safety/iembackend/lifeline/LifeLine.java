package com.iem.safety.iembackend.lifeline;


import com.iem.safety.iembackend.expectenvir.Part;
import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 生命线工程震害调查
 *
 * @author CHenXiaoTian 2018-09-03 15:24
 */
public class LifeLine {

    @Id
    private String id;
    //所属人
    private String ownerId;

    //地震id
    private String earthquakeId;

    //删除标记
    private String status;

    //时间
    private String time;

    //名称
    private String name;

    //地址
    private String adderss;

    private String lng;

    private String lat;

    private String interact;

    //Main structural form   主要结构形式
    private List<Part> msf;

    //Monomers Investigation  单体调查ID
    private String mid;

    // Comprehensive Investigation 全面调查ID
    private String cid;

    //备注
    private String remarks;

    private List<String> images;
    private List<String> videos;
    private List<String> audios;

    private List<FileEntity> imagesData;
    private List<FileEntity> videosData;
    private List<FileEntity> audiosData;

    public LifeLine() {
    }

    public LifeLine(String id, String ownerId, String earthquakeId, String status, String time, String name, String adderss, String lng, String lat, String interact, List<Part> msf, String mid, String cid, String remarks, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imagesData, List<FileEntity> videosData, List<FileEntity> audiosData) {
        this.id = id;
        this.ownerId = ownerId;
        this.earthquakeId = earthquakeId;
        this.status = status;
        this.time = time;
        this.name = name;
        this.adderss = adderss;
        this.lng = lng;
        this.lat = lat;
        this.interact = interact;
        this.msf = msf;
        this.mid = mid;
        this.cid = cid;
        this.remarks = remarks;
        this.images = images;
        this.videos = videos;
        this.audios = audios;
        this.imagesData = imagesData;
        this.videosData = videosData;
        this.audiosData = audiosData;
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

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getInteract() {
        return interact;
    }

    public void setInteract(String interact) {
        this.interact = interact;
    }

    public List<Part> getMsf() {
        return msf;
    }

    public void setMsf(List<Part> msf) {
        this.msf = msf;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public void setVdeos(List<String> videos) {
        this.videos = videos;
    }

    public List<String> getAudios() {
        return audios;
    }

    public void setAudios(List<String> audios) {
        this.audios = audios;
    }

    public List<FileEntity> getImagesData() {
        return imagesData;
    }

    public void setImagesData(List<FileEntity> imagesData) {
        this.imagesData = imagesData;
    }

    public List<FileEntity> getVideosData() {
        return videosData;
    }

    public void setVideosData(List<FileEntity> videosData) {
        this.videosData = videosData;
    }

    public List<FileEntity> getAudiosData() {
        return audiosData;
    }

    public void setAudiosData(List<FileEntity> audiosData) {
        this.audiosData = audiosData;
    }

    @Override
    public String toString() {
        return "LifeLine{" +
                "id='" + id + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", earthquakeId='" + earthquakeId + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", adderss='" + adderss + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", interact='" + interact + '\'' +
                ", msf=" + msf +
                ", mid='" + mid + '\'' +
                ", cid='" + cid + '\'' +
                ", remarks='" + remarks + '\'' +
                ", images=" + images +
                ", videos=" + videos +
                ", audios=" + audios +
                ", imagesData=" + imagesData +
                ", videosData=" + videosData +
                ", audiosData=" + audiosData +
                '}';
    }
}
