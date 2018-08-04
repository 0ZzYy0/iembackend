package com.iem.safety.iembackend.geologydisaster;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

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

    private long time;

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

    private String fileType = "image";

    private List<String> datumArrayImages;
    private List<String> datumArrayVideos;
    private List<String> datumArrayAudios;

    private List<FileEntity> datumArrayImageList;
    private List<FileEntity> datumArrayVideoList;
    private List<FileEntity> datumArrayAudioList;

    private List<String> sdosgImages;
    private List<String> sdosgVideos;
    private List<String> sdosgAudios;

    private List<FileEntity> sdosgImageList;
    private List<FileEntity> sdosgVideoList;
    private List<FileEntity> sdosgAudioList;

    private List<String> pictureArrayImages;
    private List<String> pictureArrayVideos;
    private List<String> pictureArrayAudios;

    private List<FileEntity> pictureArrayImageList;
    private List<FileEntity> pictureArrayVideoList;
    private List<FileEntity> pictureArrayAudioList;

    private List<String> fileArrayImages;
    private List<String> fileArrayVideos;
    private List<String> fileArrayAudios;

    private List<FileEntity> fileArrayImageList;
    private List<FileEntity> fileArrayVideoList;
    private List<FileEntity> fileArrayAudioList;

    private List<String> sdopasImages;
    private List<String> sdopasVideos;
    private List<String> sdopasAudios;

    private List<FileEntity> sdopasImageList;
    private List<FileEntity> sdopasVideoList;
    private List<FileEntity> sdopasAudioList;

    public GeologyDisaster(String id, String name, String lat, String lng, String intensityIndex, long time, String mark, String type, String shape, String wonaghdmic, String adderss, String lsc, String hc, String aodm, String pooeoi, String ceoi, String ownerId, String earthquakeId, String fileType, List<String> datumArrayImages, List<String> datumArrayVideos, List<String> datumArrayAudios, List<FileEntity> datumArrayImageList, List<FileEntity> datumArrayVideoList, List<FileEntity> datumArrayAudioList, List<String> sdosgImages, List<String> sdosgVideos, List<String> sdosgAudios, List<FileEntity> sdosgImageList, List<FileEntity> sdosgVideoList, List<FileEntity> sdosgAudioList, List<String> pictureArrayImages, List<String> pictureArrayVideos, List<String> pictureArrayAudios, List<FileEntity> pictureArrayImageList, List<FileEntity> pictureArrayVideoList, List<FileEntity> pictureArrayAudioList, List<String> fileArrayImages, List<String> fileArrayVideos, List<String> fileArrayAudios, List<FileEntity> fileArrayImageList, List<FileEntity> fileArrayVideoList, List<FileEntity> fileArrayAudioList, List<String> sdopasImages, List<String> sdopasVideos, List<String> sdopasAudios, List<FileEntity> sdopasImageList, List<FileEntity> sdopasVideoList, List<FileEntity> sdopasAudioList) {
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
        this.fileType = fileType;
        this.datumArrayImages = datumArrayImages;
        this.datumArrayVideos = datumArrayVideos;
        this.datumArrayAudios = datumArrayAudios;
        this.datumArrayImageList = datumArrayImageList;
        this.datumArrayVideoList = datumArrayVideoList;
        this.datumArrayAudioList = datumArrayAudioList;
        this.sdosgImages = sdosgImages;
        this.sdosgVideos = sdosgVideos;
        this.sdosgAudios = sdosgAudios;
        this.sdosgImageList = sdosgImageList;
        this.sdosgVideoList = sdosgVideoList;
        this.sdosgAudioList = sdosgAudioList;
        this.pictureArrayImages = pictureArrayImages;
        this.pictureArrayVideos = pictureArrayVideos;
        this.pictureArrayAudios = pictureArrayAudios;
        this.pictureArrayImageList = pictureArrayImageList;
        this.pictureArrayVideoList = pictureArrayVideoList;
        this.pictureArrayAudioList = pictureArrayAudioList;
        this.fileArrayImages = fileArrayImages;
        this.fileArrayVideos = fileArrayVideos;
        this.fileArrayAudios = fileArrayAudios;
        this.fileArrayImageList = fileArrayImageList;
        this.fileArrayVideoList = fileArrayVideoList;
        this.fileArrayAudioList = fileArrayAudioList;
        this.sdopasImages = sdopasImages;
        this.sdopasVideos = sdopasVideos;
        this.sdopasAudios = sdopasAudios;
        this.sdopasImageList = sdopasImageList;
        this.sdopasVideoList = sdopasVideoList;
        this.sdopasAudioList = sdopasAudioList;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
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

    public List<FileEntity> getDatumArrayImageList() {
        return datumArrayImageList;
    }

    public void setDatumArrayImageList(List<FileEntity> datumArrayImageList) {
        this.datumArrayImageList = datumArrayImageList;
    }

    public List<FileEntity> getDatumArrayVideoList() {
        return datumArrayVideoList;
    }

    public void setDatumArrayVideoList(List<FileEntity> datumArrayVideoList) {
        this.datumArrayVideoList = datumArrayVideoList;
    }

    public List<FileEntity> getDatumArrayAudioList() {
        return datumArrayAudioList;
    }

    public void setDatumArrayAudioList(List<FileEntity> datumArrayAudioList) {
        this.datumArrayAudioList = datumArrayAudioList;
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

    public List<FileEntity> getSdosgImageList() {
        return sdosgImageList;
    }

    public void setSdosgImageList(List<FileEntity> sdosgImageList) {
        this.sdosgImageList = sdosgImageList;
    }

    public List<FileEntity> getSdosgVideoList() {
        return sdosgVideoList;
    }

    public void setSdosgVideoList(List<FileEntity> sdosgVideoList) {
        this.sdosgVideoList = sdosgVideoList;
    }

    public List<FileEntity> getSdosgAudioList() {
        return sdosgAudioList;
    }

    public void setSdosgAudioList(List<FileEntity> sdosgAudioList) {
        this.sdosgAudioList = sdosgAudioList;
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

    public List<FileEntity> getPictureArrayImageList() {
        return pictureArrayImageList;
    }

    public void setPictureArrayImageList(List<FileEntity> pictureArrayImageList) {
        this.pictureArrayImageList = pictureArrayImageList;
    }

    public List<FileEntity> getPictureArrayVideoList() {
        return pictureArrayVideoList;
    }

    public void setPictureArrayVideoList(List<FileEntity> pictureArrayVideoList) {
        this.pictureArrayVideoList = pictureArrayVideoList;
    }

    public List<FileEntity> getPictureArrayAudioList() {
        return pictureArrayAudioList;
    }

    public void setPictureArrayAudioList(List<FileEntity> pictureArrayAudioList) {
        this.pictureArrayAudioList = pictureArrayAudioList;
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

    public List<FileEntity> getFileArrayImageList() {
        return fileArrayImageList;
    }

    public void setFileArrayImageList(List<FileEntity> fileArrayImageList) {
        this.fileArrayImageList = fileArrayImageList;
    }

    public List<FileEntity> getFileArrayVideoList() {
        return fileArrayVideoList;
    }

    public void setFileArrayVideoList(List<FileEntity> fileArrayVideoList) {
        this.fileArrayVideoList = fileArrayVideoList;
    }

    public List<FileEntity> getFileArrayAudioList() {
        return fileArrayAudioList;
    }

    public void setFileArrayAudioList(List<FileEntity> fileArrayAudioList) {
        this.fileArrayAudioList = fileArrayAudioList;
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

    public List<FileEntity> getSdopasImageList() {
        return sdopasImageList;
    }

    public void setSdopasImageList(List<FileEntity> sdopasImageList) {
        this.sdopasImageList = sdopasImageList;
    }

    public List<FileEntity> getSdopasVideoList() {
        return sdopasVideoList;
    }

    public void setSdopasVideoList(List<FileEntity> sdopasVideoList) {
        this.sdopasVideoList = sdopasVideoList;
    }

    public List<FileEntity> getSdopasAudioList() {
        return sdopasAudioList;
    }

    public void setSdopasAudioList(List<FileEntity> sdopasAudioList) {
        this.sdopasAudioList = sdopasAudioList;
    }
}
