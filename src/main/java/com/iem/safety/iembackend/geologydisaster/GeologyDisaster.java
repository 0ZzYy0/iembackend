package com.iem.safety.iembackend.geologydisaster;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * 地质灾害调查
 *
 * @author zy 2018-05-04 15:50
 */
@SuppressWarnings(value = "unused")
public class GeologyDisaster {

    @Id
    private String id;

    private String name;

    private String lat;

    private String lng;

    private String intensityIndex;

    private String time;

    private String mark;

    private String type;

    private String shape;

    //是否编制地质灾害分布图
    private String wonaghdmic;

    private String adderss;

    //岩性构造条件
    private String lsc;

    //水文地质条件
    private String hc;

    //变形机制分析
    private String aodm;

    //烈度评定初步意见
    private String pooeoi;

    //烈度综合评定
    private String ceoi;

    //所属人
    private String ownerId;

    //地震id
    private String earthquakeId;

    private String size;

    private String status;

    private String fileType = "image";

    private List<String> datumArrayImages;
    private List<String> datumArrayVideos;
    private List<String> datumArrayAudios;

    private List<FileEntity> datumArrayImagesData;
    private List<FileEntity> datumArrayVideosData;
    private List<FileEntity> datumArrayAudiosData;

    private List<String> sdosgImages;
    private List<String> sdosgVideos;
    private List<String> sdosgAudios;

    private List<FileEntity> sdosgImagesData;
    private List<FileEntity> sdosgVideosData;
    private List<FileEntity> sdosgAudiosData;

    private List<String> pictureArrayImages;
    private List<String> pictureArrayVideos;
    private List<String> pictureArrayAudios;

    private List<FileEntity> pictureArrayImagesData;
    private List<FileEntity> pictureArrayVideosData;
    private List<FileEntity> pictureArrayAudiosData;

    private List<String> fileArrayImages;
    private List<String> fileArrayVideos;
    private List<String> fileArrayAudios;

    private List<FileEntity> fileArrayImagesData;
    private List<FileEntity> fileArrayVideosData;
    private List<FileEntity> fileArrayAudiosData;

    private List<String> sdopasImages;
    private List<String> sdopasVideos;
    private List<String> sdopasAudios;

    private List<FileEntity> sdopasImagesData;
    private List<FileEntity> sdopasVideosData;
    private List<FileEntity> sdopasAudiosData;

    public GeologyDisaster() {
    }

    public GeologyDisaster(String id, String name, String lat, String lng, String intensityIndex, String time, String mark, String type, String shape, String wonaghdmic, String adderss, String lsc, String hc, String aodm, String pooeoi, String ceoi, String ownerId, String earthquakeId, String size, String status, String fileType, List<String> datumArrayImages, List<String> datumArrayVideos, List<String> datumArrayAudios, List<FileEntity> datumArrayImagesData, List<FileEntity> datumArrayVideosData, List<FileEntity> datumArrayAudiosData, List<String> sdosgImages, List<String> sdosgVideos, List<String> sdosgAudios, List<FileEntity> sdosgImagesData, List<FileEntity> sdosgVideosData, List<FileEntity> sdosgAudiosData, List<String> pictureArrayImages, List<String> pictureArrayVideos, List<String> pictureArrayAudios, List<FileEntity> pictureArrayImagesData, List<FileEntity> pictureArrayVideosData, List<FileEntity> pictureArrayAudiosData, List<String> fileArrayImages, List<String> fileArrayVideos, List<String> fileArrayAudios, List<FileEntity> fileArrayImagesData, List<FileEntity> fileArrayVideosData, List<FileEntity> fileArrayAudiosData, List<String> sdopasImages, List<String> sdopasVideos, List<String> sdopasAudios, List<FileEntity> sdopasImagesData, List<FileEntity> sdopasVideosData, List<FileEntity> sdopasAudiosData) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.intensityIndex = intensityIndex;
        this.time = time;
        this.mark = mark;
        this.type = type;
        this.shape = shape;
        this.wonaghdmic = wonaghdmic;
        this.adderss = adderss;
        this.lsc = lsc;
        this.hc = hc;
        this.aodm = aodm;
        this.pooeoi = pooeoi;
        this.ceoi = ceoi;
        this.ownerId = ownerId;
        this.earthquakeId = earthquakeId;
        this.size = size;
        this.status = status;
        this.fileType = fileType;
        this.datumArrayImages = datumArrayImages;
        this.datumArrayVideos = datumArrayVideos;
        this.datumArrayAudios = datumArrayAudios;
        this.datumArrayImagesData = datumArrayImagesData;
        this.datumArrayVideosData = datumArrayVideosData;
        this.datumArrayAudiosData = datumArrayAudiosData;
        this.sdosgImages = sdosgImages;
        this.sdosgVideos = sdosgVideos;
        this.sdosgAudios = sdosgAudios;
        this.sdosgImagesData = sdosgImagesData;
        this.sdosgVideosData = sdosgVideosData;
        this.sdosgAudiosData = sdosgAudiosData;
        this.pictureArrayImages = pictureArrayImages;
        this.pictureArrayVideos = pictureArrayVideos;
        this.pictureArrayAudios = pictureArrayAudios;
        this.pictureArrayImagesData = pictureArrayImagesData;
        this.pictureArrayVideosData = pictureArrayVideosData;
        this.pictureArrayAudiosData = pictureArrayAudiosData;
        this.fileArrayImages = fileArrayImages;
        this.fileArrayVideos = fileArrayVideos;
        this.fileArrayAudios = fileArrayAudios;
        this.fileArrayImagesData = fileArrayImagesData;
        this.fileArrayVideosData = fileArrayVideosData;
        this.fileArrayAudiosData = fileArrayAudiosData;
        this.sdopasImages = sdopasImages;
        this.sdopasVideos = sdopasVideos;
        this.sdopasAudios = sdopasAudios;
        this.sdopasImagesData = sdopasImagesData;
        this.sdopasVideosData = sdopasVideosData;
        this.sdopasAudiosData = sdopasAudiosData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIntensityIndex() {
        return intensityIndex;
    }

    public void setIntensityIndex(String intensityIndex) {
        this.intensityIndex = intensityIndex;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getWonaghdmic() {
        return wonaghdmic;
    }

    public void setWonaghdmic(String wonaghdmic) {
        this.wonaghdmic = wonaghdmic;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public String getLsc() {
        return lsc;
    }

    public void setLsc(String lsc) {
        this.lsc = lsc;
    }

    public String getHc() {
        return hc;
    }

    public void setHc(String hc) {
        this.hc = hc;
    }

    public String getAodm() {
        return aodm;
    }

    public void setAodm(String aodm) {
        this.aodm = aodm;
    }

    public String getPooeoi() {
        return pooeoi;
    }

    public void setPooeoi(String pooeoi) {
        this.pooeoi = pooeoi;
    }

    public String getCeoi() {
        return ceoi;
    }

    public void setCeoi(String ceoi) {
        this.ceoi = ceoi;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<String> getDatumArrayImages() {
        return datumArrayImages;
    }

    public void setDatumArrayImages(List<String> datumArrayImages) {
        this.datumArrayImages = datumArrayImages;
    }

    public List<String> getDatumArrayVideos() {
        return datumArrayVideos;
    }

    public void setDatumArrayVideos(List<String> datumArrayVideos) {
        this.datumArrayVideos = datumArrayVideos;
    }

    public List<String> getDatumArrayAudios() {
        return datumArrayAudios;
    }

    public void setDatumArrayAudios(List<String> datumArrayAudios) {
        this.datumArrayAudios = datumArrayAudios;
    }

    public List<FileEntity> getDatumArrayImagesData() {
        return datumArrayImagesData;
    }

    public void setDatumArrayImagesData(List<FileEntity> datumArrayImagesData) {
        this.datumArrayImagesData = datumArrayImagesData;
    }

    public List<FileEntity> getDatumArrayVideosData() {
        return datumArrayVideosData;
    }

    public void setDatumArrayVideosData(List<FileEntity> datumArrayVideosData) {
        this.datumArrayVideosData = datumArrayVideosData;
    }

    public List<FileEntity> getDatumArrayAudiosData() {
        return datumArrayAudiosData;
    }

    public void setDatumArrayAudiosData(List<FileEntity> datumArrayAudiosData) {
        this.datumArrayAudiosData = datumArrayAudiosData;
    }

    public List<String> getSdosgImages() {
        return sdosgImages;
    }

    public void setSdosgImages(List<String> sdosgImages) {
        this.sdosgImages = sdosgImages;
    }

    public List<String> getSdosgVideos() {
        return sdosgVideos;
    }

    public void setSdosgVideos(List<String> sdosgVideos) {
        this.sdosgVideos = sdosgVideos;
    }

    public List<String> getSdosgAudios() {
        return sdosgAudios;
    }

    public void setSdosgAudios(List<String> sdosgAudios) {
        this.sdosgAudios = sdosgAudios;
    }

    public List<FileEntity> getSdosgImagesData() {
        return sdosgImagesData;
    }

    public void setSdosgImagesData(List<FileEntity> sdosgImagesData) {
        this.sdosgImagesData = sdosgImagesData;
    }

    public List<FileEntity> getSdosgVideosData() {
        return sdosgVideosData;
    }

    public void setSdosgVideosData(List<FileEntity> sdosgVideosData) {
        this.sdosgVideosData = sdosgVideosData;
    }

    public List<FileEntity> getSdosgAudiosData() {
        return sdosgAudiosData;
    }

    public void setSdosgAudiosData(List<FileEntity> sdosgAudiosData) {
        this.sdosgAudiosData = sdosgAudiosData;
    }

    public List<String> getPictureArrayImages() {
        return pictureArrayImages;
    }

    public void setPictureArrayImages(List<String> pictureArrayImages) {
        this.pictureArrayImages = pictureArrayImages;
    }

    public List<String> getPictureArrayVideos() {
        return pictureArrayVideos;
    }

    public void setPictureArrayVideos(List<String> pictureArrayVideos) {
        this.pictureArrayVideos = pictureArrayVideos;
    }

    public List<String> getPictureArrayAudios() {
        return pictureArrayAudios;
    }

    public void setPictureArrayAudios(List<String> pictureArrayAudios) {
        this.pictureArrayAudios = pictureArrayAudios;
    }

    public List<FileEntity> getPictureArrayImagesData() {
        return pictureArrayImagesData;
    }

    public void setPictureArrayImagesData(List<FileEntity> pictureArrayImagesData) {
        this.pictureArrayImagesData = pictureArrayImagesData;
    }

    public List<FileEntity> getPictureArrayVideosData() {
        return pictureArrayVideosData;
    }

    public void setPictureArrayVideosData(List<FileEntity> pictureArrayVideosData) {
        this.pictureArrayVideosData = pictureArrayVideosData;
    }

    public List<FileEntity> getPictureArrayAudiosData() {
        return pictureArrayAudiosData;
    }

    public void setPictureArrayAudiosData(List<FileEntity> pictureArrayAudiosData) {
        this.pictureArrayAudiosData = pictureArrayAudiosData;
    }

    public List<String> getFileArrayImages() {
        return fileArrayImages;
    }

    public void setFileArrayImages(List<String> fileArrayImages) {
        this.fileArrayImages = fileArrayImages;
    }

    public List<String> getFileArrayVideos() {
        return fileArrayVideos;
    }

    public void setFileArrayVideos(List<String> fileArrayVideos) {
        this.fileArrayVideos = fileArrayVideos;
    }

    public List<String> getFileArrayAudios() {
        return fileArrayAudios;
    }

    public void setFileArrayAudios(List<String> fileArrayAudios) {
        this.fileArrayAudios = fileArrayAudios;
    }

    public List<FileEntity> getFileArrayImagesData() {
        return fileArrayImagesData;
    }

    public void setFileArrayImagesData(List<FileEntity> fileArrayImagesData) {
        this.fileArrayImagesData = fileArrayImagesData;
    }

    public List<FileEntity> getFileArrayVideosData() {
        return fileArrayVideosData;
    }

    public void setFileArrayVideosData(List<FileEntity> fileArrayVideosData) {
        this.fileArrayVideosData = fileArrayVideosData;
    }

    public List<FileEntity> getFileArrayAudiosData() {
        return fileArrayAudiosData;
    }

    public void setFileArrayAudiosData(List<FileEntity> fileArrayAudiosData) {
        this.fileArrayAudiosData = fileArrayAudiosData;
    }

    public List<String> getSdopasImages() {
        return sdopasImages;
    }

    public void setSdopasImages(List<String> sdopasImages) {
        this.sdopasImages = sdopasImages;
    }

    public List<String> getSdopasVideos() {
        return sdopasVideos;
    }

    public void setSdopasVideos(List<String> sdopasVideos) {
        this.sdopasVideos = sdopasVideos;
    }

    public List<String> getSdopasAudios() {
        return sdopasAudios;
    }

    public void setSdopasAudios(List<String> sdopasAudios) {
        this.sdopasAudios = sdopasAudios;
    }

    public List<FileEntity> getSdopasImagesData() {
        return sdopasImagesData;
    }

    public void setSdopasImagesData(List<FileEntity> sdopasImagesData) {
        this.sdopasImagesData = sdopasImagesData;
    }

    public List<FileEntity> getSdopasVideosData() {
        return sdopasVideosData;
    }

    public void setSdopasVideosData(List<FileEntity> sdopasVideosData) {
        this.sdopasVideosData = sdopasVideosData;
    }

    public List<FileEntity> getSdopasAudiosData() {
        return sdopasAudiosData;
    }

    public void setSdopasAudiosData(List<FileEntity> sdopasAudiosData) {
        this.sdopasAudiosData = sdopasAudiosData;
    }

    @Override
    public String toString() {
        return "GeologyDisaster{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", intensityIndex='" + intensityIndex + '\'' +
                ", time='" + time + '\'' +
                ", mark='" + mark + '\'' +
                ", type='" + type + '\'' +
                ", shape='" + shape + '\'' +
                ", wonaghdmic='" + wonaghdmic + '\'' +
                ", adderss='" + adderss + '\'' +
                ", lsc='" + lsc + '\'' +
                ", hc='" + hc + '\'' +
                ", aodm='" + aodm + '\'' +
                ", pooeoi='" + pooeoi + '\'' +
                ", ceoi='" + ceoi + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", earthquakeId='" + earthquakeId + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", fileType='" + fileType + '\'' +
                ", datumArrayImages=" + datumArrayImages +
                ", datumArrayVideos=" + datumArrayVideos +
                ", datumArrayAudios=" + datumArrayAudios +
                ", datumArrayImagesData=" + datumArrayImagesData +
                ", datumArrayVideosData=" + datumArrayVideosData +
                ", datumArrayAudiosData=" + datumArrayAudiosData +
                ", sdosgImages=" + sdosgImages +
                ", sdosgVideos=" + sdosgVideos +
                ", sdosgAudios=" + sdosgAudios +
                ", sdosgImagesData=" + sdosgImagesData +
                ", sdosgVideosData=" + sdosgVideosData +
                ", sdosgAudiosData=" + sdosgAudiosData +
                ", pictureArrayImages=" + pictureArrayImages +
                ", pictureArrayVideos=" + pictureArrayVideos +
                ", pictureArrayAudios=" + pictureArrayAudios +
                ", pictureArrayImagesData=" + pictureArrayImagesData +
                ", pictureArrayVideosData=" + pictureArrayVideosData +
                ", pictureArrayAudiosData=" + pictureArrayAudiosData +
                ", fileArrayImages=" + fileArrayImages +
                ", fileArrayVideos=" + fileArrayVideos +
                ", fileArrayAudios=" + fileArrayAudios +
                ", fileArrayImagesData=" + fileArrayImagesData +
                ", fileArrayVideosData=" + fileArrayVideosData +
                ", fileArrayAudiosData=" + fileArrayAudiosData +
                ", sdopasImages=" + sdopasImages +
                ", sdopasVideos=" + sdopasVideos +
                ", sdopasAudios=" + sdopasAudios +
                ", sdopasImagesData=" + sdopasImagesData +
                ", sdopasVideosData=" + sdopasVideosData +
                ", sdopasAudiosData=" + sdopasAudiosData +
                '}';
    }
}
