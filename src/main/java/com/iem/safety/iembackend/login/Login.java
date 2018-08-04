package com.iem.safety.iembackend.login;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-06-05 21:31
 */
public class Login {
    @Id
    private String id;
    private String loginAccount;
    private String password;
    private String ip;
    private String dateTime;

    public Login() {
    }

    public Login(String id, String loginAccount, String password, String ip, String dateTime) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.password = password;
        this.ip = ip;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
