package com.iem.safety.iembackend.superadmin;

import com.iem.safety.iembackend.login.Login;
import com.iem.safety.iembackend.login.LoginRepository;
import com.iem.safety.iembackend.utils.MD5Utils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class SuperAdminService {

    private final SuperAdminRepository repository;
    private final LoginRepository loginRepository;

    public SuperAdminService(SuperAdminRepository repository, LoginRepository loginRepository) {
        this.repository = repository;
        this.loginRepository = loginRepository;
    }

    public SuperAdmin login(String loginAccount, long timestamp, String sign, HttpServletRequest request) {
        SuperAdmin superAdmin = repository.findSuperAdminByLoginAccount(loginAccount);
        if (superAdmin == null) return null;
        Login login = new Login();
        String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        login.setDateTime(new DateTime(timestamp).toString(DATETIME_FORMAT));
        login.setLoginAccount(loginAccount);
        login.setIp(request.getRemoteAddr());
        loginRepository.insert(login);
        String encryption = (superAdmin.getLoginPassword() + timestamp);
        String md5Sign = MD5Utils.MD5(encryption);
        if (sign.equals(md5Sign)) {
            request.getSession().setAttribute("_role", "su");
            request.getSession().setAttribute("_session_user", superAdmin);
            SuperAdmin newSu = new SuperAdmin();
            newSu.setId("ok");
            return newSu;
        } else return null;
    }

}
