package com.iem.safety.iembackend.multisurvey;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 烈度调查
 *
 * @author MengQi 2018-05-04 15:50
 */
@SuppressWarnings(value = "unused")
public class Multisurvey {

    @Id
    private String id;

    private String uuid;

    private String surveyId;

    private String surveyUuid;
    private String earthquakeId;
    private String ownerId;
    private String openId;
    private List<PartSurvey> partSurveyList;

    public Multisurvey(String id, String uuid, String surveyId, String surveyUuid, String earthquakeId, String ownerId, String openId, List<PartSurvey> partSurveyList) {
        this.id = id;
        this.uuid = uuid;
        this.surveyId = surveyId;
        this.surveyUuid = surveyUuid;
        this.earthquakeId = earthquakeId;
        this.ownerId = ownerId;
        this.openId = openId;
        this.partSurveyList = partSurveyList;
    }

    public Multisurvey() {
    }

    public Multisurvey(String id, String uuid, String surveyId, String surveyUuid, String ownerId, String openId, List<PartSurvey> partSurveyList) {

        this.id = id;
        this.uuid = uuid;
        this.surveyId = surveyId;
        this.surveyUuid = surveyUuid;
        this.ownerId = ownerId;
        this.openId = openId;
        this.partSurveyList = partSurveyList;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyUuid() {
        return surveyUuid;
    }

    public void setSurveyUuid(String surveyUuid) {
        this.surveyUuid = surveyUuid;
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

    public List<PartSurvey> getPartSurveyList() {
        return partSurveyList;
    }

    public void setPartSurveyList(List<PartSurvey> partSurveyList) {
        this.partSurveyList = partSurveyList;
    }
}
