package com.iem.safety.iembackend.detailpartinfo;

/**
 * @author MengQi 2018-06-20 21:44
 */
public class Damage {


    private String number;//数量：个别、少数、多数

    private String degree;// 程度：轻微、中等、严重

    private String describe;

    public Damage(String number, String degree, String describe) {
        this.number = number;
        this.degree = degree;
        this.describe = describe;
    }

    public Damage() {
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}
