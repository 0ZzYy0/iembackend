package com.iem.safety.iembackend.superadmin;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-05-22 19:33
 */
@SuppressWarnings(value = "unused")
public class SuperAdmin {
    @Id
    private String id;

    private String loginAccount;

    private String loginPassword;

    public SuperAdmin() {
    }

    public SuperAdmin(String id, String loginAccount, String loginPassword) {
        this.id = id;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
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
}
