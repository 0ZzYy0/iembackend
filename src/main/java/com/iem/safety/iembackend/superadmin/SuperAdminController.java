package com.iem.safety.iembackend.superadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("su")
@SuppressWarnings(value = "unused")
public class SuperAdminController {

    private final SuperAdminService service;

    @Autowired
    public SuperAdminController(SuperAdminService service) {
        this.service = service;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public SuperAdmin login(@RequestParam("loginAccount") String loginAccount,
                            @RequestParam("timestamp") long timestamp,
                            @RequestParam("sign") String sign,
                            HttpServletRequest request) {
        return service.login(loginAccount, timestamp, sign, request);
    }


}
