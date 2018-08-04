package com.iem.safety.iembackend.singlesurvey;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 烈度调查
 *
 * @author MengQi 2018-05-04 15:50
 */
@SuppressWarnings(value = "unused")
public class Singlesurvey extends BasicInfo {

    @Id
    private String id;
    private String earthquakeId;
    private String years;
    private String flattenedForm;

    public Singlesurvey(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String houseHost, boolean fortified, String regionParam, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList, String id, String earthquakeId, String years, String flattenedForm) {
        super(uuid, surveyId, surveyUuid, ownerId, openId, houseHost, fortified, regionParam, name, address, lat, lng, dateTime, timestamp, mark, area, status, damage, areaType, structType, usage, kangZhen, fileType, assessed, images, videos, audios, imageList, videoList, audioList);
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.years = years;
        this.flattenedForm = flattenedForm;
    }

    public Singlesurvey() {
        super();
    }


    public Singlesurvey(String uuid, String surveyId, String surveyUuid, String ownerId, String openId, String houseHost, boolean fortified, String regionParam, String name, String address, String lat, String lng, String dateTime, long timestamp, String mark, String area, String status, String damage, String areaType, String structType, String usage, String kangZhen, String fileType, boolean assessed, List<String> images, List<String> videos, List<String> audios, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList, String id) {
        super(uuid, surveyId, surveyUuid, ownerId, openId, houseHost, fortified, regionParam, name, address, lat, lng, dateTime, timestamp, mark, area, status, damage, areaType, structType, usage, kangZhen, fileType, assessed, images, videos, audios, imageList, videoList, audioList);
        this.id = id;
    }

    public Singlesurvey(BasicInfo basicInfo, String id) {
        super(basicInfo);
        this.id = id;
    }

    public String getFlattenedForm() {
        return flattenedForm;
    }


    public void setFlattenedForm(String flattenedForm) {
        this.flattenedForm = flattenedForm;
    }

    public String getYears() {
        return years;
    }


    public void setYears(String years) {
        this.years = years;
    }

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
