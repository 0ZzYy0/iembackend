package com.iem.safety.iembackend.lifelineMonomers;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import java.util.List;

public class LifeLineMonomers {

    @Id
    private String id;

    //单项调查id
    private String mId;
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
    //经度
    private String lng;
    //纬度
    private String lat;
    //主要结构形式
    private String msf;
    //破坏前状况
    private String pdc;
    //破坏等级
    private String damageGrade;
    //设防烈度
    private String fortificationIntensity;
    //场地类别
    private String siteCategory;
    //建造材料
    private String buildingMaterials;
    //建筑年代
    private String architecturalAge;
    //地震烈度
    private String earthquakeIntensity;
    //中断时间
    private String interruptionTime;
    //恢复时间
    private String recoveryTime;
    //中断期间对应急救灾的影响 Impact of interruption period on emergency relief
    private String ioipoer;
    //引起生命线工程震害的主要原因 Main causes of earthquake damage to Lifeline Engineering
    private String mcoedtle;

    //水池或水处理池
    private String powtp;

    //水厂处理
    private String wtp;

    //取水井站及供水泵站
    private String iwsawsps;

    //供水管网
    private String wsn;

    //门站
    private String gateStation;

    //煤气罐
    private String gst;

    //输气管线
    private String gtp;

    //道路
    private String road;

    //隧道
    private String tunnel;

    //桥梁
    private String bridge;

    //铁道线路
    private String railwayLine;

    //发电厂
    private String powerPlant;

    //变（配）电站
    private String substation;

    //输电线路
    private String transmissionLine;

    //中心控制室
    private String centralControlRoom;

    //通信线路
    private String communicationLine;

    private List<String> images;
    private List<String> videos;
    private List<String> audios;

    private List<FileEntity> imagesData;
    private List<FileEntity> videosData;
    private List<FileEntity> audiosData;

    public LifeLineMonomers() {
    }

    public LifeLineMonomers(String id, String mId, String earthquakeId, String status, String time, String name, String adderss, String lng, String lat, String msf, String pdc, String damageGrade, String fortificationIntensity, String siteCategory, String buildingMaterials, String architecturalAge, String earthquakeIntensity, String interruptionTime, String recoveryTime, String ioipoer, String mcoedtle, String powtp, String wtp, String iwsawsps, String wsn, String gateStation, String gst, String gtp, String road, String tunnel, String bridge, String railwayLine, String powerPlant, String substation, String transmissionLine, String centralControlRoom, String communicationLine, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imagesData, List<FileEntity> videosData, List<FileEntity> audiosData) {
        this.id = id;
        this.mId = mId;
        this.earthquakeId = earthquakeId;
        this.status = status;
        this.time = time;
        this.name = name;
        this.adderss = adderss;
        this.lng = lng;
        this.lat = lat;
        this.msf = msf;
        this.pdc = pdc;
        this.damageGrade = damageGrade;
        this.fortificationIntensity = fortificationIntensity;
        this.siteCategory = siteCategory;
        this.buildingMaterials = buildingMaterials;
        this.architecturalAge = architecturalAge;
        this.earthquakeIntensity = earthquakeIntensity;
        this.interruptionTime = interruptionTime;
        this.recoveryTime = recoveryTime;
        this.ioipoer = ioipoer;
        this.mcoedtle = mcoedtle;
        this.powtp = powtp;
        this.wtp = wtp;
        this.iwsawsps = iwsawsps;
        this.wsn = wsn;
        this.gateStation = gateStation;
        this.gst = gst;
        this.gtp = gtp;
        this.road = road;
        this.tunnel = tunnel;
        this.bridge = bridge;
        this.railwayLine = railwayLine;
        this.powerPlant = powerPlant;
        this.substation = substation;
        this.transmissionLine = transmissionLine;
        this.centralControlRoom = centralControlRoom;
        this.communicationLine = communicationLine;
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

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
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

    public String getMsf() {
        return msf;
    }

    public void setMsf(String msf) {
        this.msf = msf;
    }

    public String getPdc() {
        return pdc;
    }

    public void setPdc(String pdc) {
        this.pdc = pdc;
    }

    public String getDamageGrade() {
        return damageGrade;
    }

    public void setDamageGrade(String damageGrade) {
        this.damageGrade = damageGrade;
    }

    public String getFortificationIntensity() {
        return fortificationIntensity;
    }

    public void setFortificationIntensity(String fortificationIntensity) {
        this.fortificationIntensity = fortificationIntensity;
    }

    public String getSiteCategory() {
        return siteCategory;
    }

    public void setSiteCategory(String siteCategory) {
        this.siteCategory = siteCategory;
    }

    public String getBuildingMaterials() {
        return buildingMaterials;
    }

    public void setBuildingMaterials(String buildingMaterials) {
        this.buildingMaterials = buildingMaterials;
    }

    public String getArchitecturalAge() {
        return architecturalAge;
    }

    public void setArchitecturalAge(String architecturalAge) {
        this.architecturalAge = architecturalAge;
    }

    public String getEarthquakeIntensity() {
        return earthquakeIntensity;
    }

    public void setEarthquakeIntensity(String earthquakeIntensity) {
        this.earthquakeIntensity = earthquakeIntensity;
    }

    public String getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(String interruptionTime) {
        this.interruptionTime = interruptionTime;
    }

    public String getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(String recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public String getIoipoer() {
        return ioipoer;
    }

    public void setIoipoer(String ioipoer) {
        this.ioipoer = ioipoer;
    }

    public String getMcoedtle() {
        return mcoedtle;
    }

    public void setMcoedtle(String mcoedtle) {
        this.mcoedtle = mcoedtle;
    }

    public String getPowtp() {
        return powtp;
    }

    public void setPowtp(String powtp) {
        this.powtp = powtp;
    }

    public String getWtp() {
        return wtp;
    }

    public void setWtp(String wtp) {
        this.wtp = wtp;
    }

    public String getIwsawsps() {
        return iwsawsps;
    }

    public void setIwsawsps(String iwsawsps) {
        this.iwsawsps = iwsawsps;
    }

    public String getWsn() {
        return wsn;
    }

    public void setWsn(String wsn) {
        this.wsn = wsn;
    }

    public String getGateStation() {
        return gateStation;
    }

    public void setGateStation(String gateStation) {
        this.gateStation = gateStation;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getGtp() {
        return gtp;
    }

    public void setGtp(String gtp) {
        this.gtp = gtp;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getTunnel() {
        return tunnel;
    }

    public void setTunnel(String tunnel) {
        this.tunnel = tunnel;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getRailwayLine() {
        return railwayLine;
    }

    public void setRailwayLine(String railwayLine) {
        this.railwayLine = railwayLine;
    }

    public String getPowerPlant() {
        return powerPlant;
    }

    public void setPowerPlant(String powerPlant) {
        this.powerPlant = powerPlant;
    }

    public String getSubstation() {
        return substation;
    }

    public void setSubstation(String substation) {
        this.substation = substation;
    }

    public String getTransmissionLine() {
        return transmissionLine;
    }

    public void setTransmissionLine(String transmissionLine) {
        this.transmissionLine = transmissionLine;
    }

    public String getCentralControlRoom() {
        return centralControlRoom;
    }

    public void setCentralControlRoom(String centralControlRoom) {
        this.centralControlRoom = centralControlRoom;
    }

    public String getCommunicationLine() {
        return communicationLine;
    }

    public void setCommunicationLine(String communicationLine) {
        this.communicationLine = communicationLine;
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
        return "LifeLineMonomers{" +
                "id='" + id + '\'' +
                ", mId='" + mId + '\'' +
                ", earthquakeId='" + earthquakeId + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", adderss='" + adderss + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", msf='" + msf + '\'' +
                ", pdc='" + pdc + '\'' +
                ", damageGrade='" + damageGrade + '\'' +
                ", fortificationIntensity='" + fortificationIntensity + '\'' +
                ", siteCategory='" + siteCategory + '\'' +
                ", buildingMaterials='" + buildingMaterials + '\'' +
                ", architecturalAge='" + architecturalAge + '\'' +
                ", earthquakeIntensity='" + earthquakeIntensity + '\'' +
                ", interruptionTime='" + interruptionTime + '\'' +
                ", recoveryTime='" + recoveryTime + '\'' +
                ", ioipoer='" + ioipoer + '\'' +
                ", mcoedtle='" + mcoedtle + '\'' +
                ", powtp='" + powtp + '\'' +
                ", wtp='" + wtp + '\'' +
                ", iwsawsps='" + iwsawsps + '\'' +
                ", wsn='" + wsn + '\'' +
                ", gateStation='" + gateStation + '\'' +
                ", gst='" + gst + '\'' +
                ", gtp='" + gtp + '\'' +
                ", road='" + road + '\'' +
                ", tunnel='" + tunnel + '\'' +
                ", bridge='" + bridge + '\'' +
                ", railwayLine='" + railwayLine + '\'' +
                ", powerPlant='" + powerPlant + '\'' +
                ", substation='" + substation + '\'' +
                ", transmissionLine='" + transmissionLine + '\'' +
                ", centralControlRoom='" + centralControlRoom + '\'' +
                ", communicationLine='" + communicationLine + '\'' +
                ", images=" + images +
                ", videos=" + videos +
                ", audios=" + audios +
                ", imagesData=" + imagesData +
                ", videosData=" + videosData +
                ", audiosData=" + audiosData +
                '}';
    }
}
