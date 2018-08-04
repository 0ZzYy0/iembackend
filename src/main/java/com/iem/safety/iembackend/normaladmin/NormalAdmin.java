package com.iem.safety.iembackend.normaladmin;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-06-05 21:31
 */
@SuppressWarnings(value = "unused")
public class NormalAdmin {
    @Id
    private String id;

    private String earthquakeId;

    private String loginAccount;

    private String loginPassword;

    private String role;

    private String timestamp;

    public NormalAdmin(String id, String earthquakeId, String loginAccount, String loginPassword, String role, String timestamp) {
        this.id = id;
        this.earthquakeId = earthquakeId;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.role = role;
        this.timestamp = timestamp;
    }

    public NormalAdmin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
