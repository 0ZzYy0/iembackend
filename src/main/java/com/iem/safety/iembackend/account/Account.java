package com.iem.safety.iembackend.account;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class Account {
    @Id
    private String id;

    private String loginAccount;

    private String loginPassword;

    private String openId;
    private String customerId;
    private long timestamp;

    public Account(String id, String loginAccount, String loginPassword, String openId, String customerId, long timestamp) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.openId = openId;
        this.customerId = customerId;
        this.timestamp = timestamp;
    }

    public Account() {
    }


    public Account(String id, String loginAccount, String loginPassword, String openId, long timestamp) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.openId = openId;
        this.timestamp = timestamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
