package com.iem.safety.iembackend.customer;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-02 16:19
 */
@SuppressWarnings("unused")
public class Customer {

    @Id
    private String id;

    private String openId = "";

    private String name = "";

    private String department = "";

    private String discipline = "";

    private String email = "";

    private String phone = "";

    private String address = "";

    private String zipCode = "";

    private String registered = "no";

    private String profTitle = "";

    private String role = "普通用户";

    public Customer() {
        super();
    }

    /**
     * @param id         id
     * @param openId     openid
     * @param name       姓名
     * @param department 工作单位
     * @param discipline 专业
     * @param email      邮箱
     * @param phone      电话
     * @param address    地址
     * @param zipCode    邮编
     * @param profTitle  职称
     * @param registered 是否注册
     * @param role       用户角色
     */
    public Customer(String id, String openId, String name, String department, String discipline, String email, String phone, String address, String zipCode, String registered, String profTitle, String role) {
        this.id = id;
        this.openId = openId;
        this.name = name;
        this.department = department;
        this.discipline = discipline;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.registered = registered;
        this.profTitle = profTitle;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfTitle() {
        return profTitle;
    }

    public void setProfTitle(String profTitle) {
        this.profTitle = profTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getRegistered() {
        return registered;
    }


    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
