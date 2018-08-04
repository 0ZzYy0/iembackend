package com.iem.safety.iembackend.multisurvey;

/**
 * @author MengQi 2018-05-08 16:13
 */
@SuppressWarnings("unused")
public class PartSurvey {
    private String name;
    private String factor;
    private String area;
    private String damage;
    private String severe;
    private String middle;
    private String little;
    private String basic;


    public PartSurvey() {
    }

    public PartSurvey(String name, String factor, String area, String damage, String severe, String middle, String little, String basic) {

        this.name = name;
        this.factor = factor;
        this.area = area;
        this.damage = damage;
        this.severe = severe;
        this.middle = middle;
        this.little = little;
        this.basic = basic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
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

    public String getSevere() {
        return severe;
    }

    public void setSevere(String severe) {
        this.severe = severe;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLittle() {
        return little;
    }

    public void setLittle(String little) {
        this.little = little;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }
}
