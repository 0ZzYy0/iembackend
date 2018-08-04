package com.iem.safety.iembackend.safetyassess;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import com.iem.safety.iembackend.singlesurvey.BasicInfo;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 烈度调查
 *
 * @author MengQi 2018-05-04 15:50
 */
@SuppressWarnings(value = "unused")
public class Safetyassess extends BasicInfo {


    @Id
    private String id;
    private String earthquakeId;
    private String result;
    private String localNumOfLayers;
    private String mainUnderGround;
    private String mainOnGround;


    public Safetyassess(String id, String earthquakeId, String result, String localNumOfLayers, String mainUnderGround, String mainOnGround) {
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.result = result;
        this.localNumOfLayers = localNumOfLayers;
        this.mainUnderGround = mainUnderGround;
        this.mainOnGround = mainOnGround;
    }

    public Safetyassess() {
        super();
    }

    public Safetyassess(BasicInfo basicInfo, String id) {
        super(basicInfo);
        this.id = id;
    }

    public Safetyassess(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String houseHost, boolean fortified, String regionParam, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList, String id, String earthquakeId, String result, String localNumOfLayers, String mainUnderGround, String mainOnGround) {
        super(uuid, surveyId, surveyUuid, ownerId, openId, houseHost, fortified, regionParam, name, address, lat, lng, dateTime, timestamp, mark, area, status, damage, areaType, structType, usage, kangZhen, fileType, assessed, images, videos, audios, imageList, videoList, audioList);
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.result = result;
        this.localNumOfLayers = localNumOfLayers;
        this.mainUnderGround = mainUnderGround;
        this.mainOnGround = mainOnGround;
    }

    public String getEarthquakeId() {

        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    //    public Safetyassess(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList, String id, String result, String localNumOfLayers, String mainUnderGround, String mainOnGround) {
//        super(uuid, surveyId, surveyUuid, ownerId, openId, name, address, lat, lng, dateTime, timestamp, mark, area, status, damage, areaType, structType, usage, kangZhen, fileType, assessed, images, videos, audios, imageList, videoList, audioList);
//        this.id = id;
//        this.result = result;
//        this.localNumOfLayers = localNumOfLayers;
//        this.mainUnderGround = mainUnderGround;
//        this.mainOnGround = mainOnGround;
//    }

    public String getLocalNumOfLayers() {
        return localNumOfLayers;
    }

    public void setLocalNumOfLayers(String localNumOfLayers) {
        this.localNumOfLayers = localNumOfLayers;
    }

    public String getMainUnderGround() {
        return mainUnderGround;
    }

    public void setMainUnderGround(String mainUnderGround) {
        this.mainUnderGround = mainUnderGround;
    }

    public String getMainOnGround() {
        return mainOnGround;
    }

    public void setMainOnGround(String mainOnGround) {
        this.mainOnGround = mainOnGround;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}



