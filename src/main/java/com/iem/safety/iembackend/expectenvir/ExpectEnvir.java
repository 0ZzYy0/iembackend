package com.iem.safety.iembackend.expectenvir;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 环境信息预期地震
 *
 * @author MengQi 2018-06-20 15:24
 */
public class ExpectEnvir {
    @Id
    private String id;
    private String liOther = "";//场地
    private String fcOther = "";//地基
    private String abOther = "";//毗邻


    private List<Part> locationInfluence;//场地
    private String assessId;
    private List<Part> foundationCondition;//地基
    private List<Part> adjoiningBuilding;//毗邻

    private String yetIntensity;//既发生地震烈度
    private String expectEffect;//预期作用
    private String EffectType;


    public ExpectEnvir(String id, String liOther, String fcOther, String abOther, List<Part> locationInfluence, String assessId, List<Part> foundationCondition, List<Part> adjoiningBuilding, String yetIntensity, String expectEffect, String effectType) {
        this.id = id;
        this.liOther = liOther;
        this.fcOther = fcOther;
        this.abOther = abOther;
        this.locationInfluence = locationInfluence;
        this.assessId = assessId;
        this.foundationCondition = foundationCondition;
        this.adjoiningBuilding = adjoiningBuilding;
        this.yetIntensity = yetIntensity;
        this.expectEffect = expectEffect;
        EffectType = effectType;
    }

    public ExpectEnvir() {
    }

    public String getExpectEffect() {
        return expectEffect;
    }

    public void setExpectEffect(String expectEffect) {
        this.expectEffect = expectEffect;
    }

    public String getEffectType() {
        return EffectType;
    }

    public void setEffectType(String effectType) {
        EffectType = effectType;
    }

    public String getLiOther() {
        return liOther;
    }

    public void setLiOther(String liOther) {
        this.liOther = liOther;
    }

    public String getFcOther() {
        return fcOther;
    }

    public void setFcOther(String fcOther) {
        this.fcOther = fcOther;
    }

    public String getAbOther() {
        return abOther;
    }

    public void setAbOther(String abOther) {
        this.abOther = abOther;
    }

    public String getYetIntensity() {
        return yetIntensity;
    }

    public void setYetIntensity(String yetIntensity) {
        this.yetIntensity = yetIntensity;
    }

    public List<Part> getLocationInfluence() {
        return locationInfluence;
    }

    public void setLocationInfluence(List<Part> locationInfluence) {
        this.locationInfluence = locationInfluence;
    }

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId;
    }

    public List<Part> getFoundationCondition() {
        return foundationCondition;
    }

    public void setFoundationCondition(List<Part> foundationCondition) {
        this.foundationCondition = foundationCondition;
    }

    public List<Part> getAdjoiningBuilding() {
        return adjoiningBuilding;
    }

    public void setAdjoiningBuilding(List<Part> adjoiningBuilding) {
        this.adjoiningBuilding = adjoiningBuilding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

