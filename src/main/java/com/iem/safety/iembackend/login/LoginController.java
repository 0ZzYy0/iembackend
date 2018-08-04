package com.iem.safety.iembackend.login;

import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.earthquake.Earthquake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-06-05 21:32
 */
@RestController
@RequestMapping("login")
@SuppressWarnings(value = "unused")
public class LoginController {

    private final LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @RequestMapping(value = "normalcustomer", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam("loginAccount") String loginAccount,
                                  @RequestParam("timestamp") long timestamp,
                                  @RequestParam("sign") String sign,
                                  HttpServletRequest request) {
        return service.loginCustomer(loginAccount, timestamp, sign, request);
    }

    @RequestMapping(value = "normaladmin", method = RequestMethod.POST)
    public Earthquake loginAdmin(@RequestParam("loginAccount") String loginAccount,
                                 @RequestParam("timestamp") long timestamp,
                                 @RequestParam("sign") String sign,
                                 HttpServletRequest request) {
        return service.loginAdmin(loginAccount, timestamp, sign, request);
    }


/**
 @RequestMapping(value = "testremote", method = RequestMethod.GET)
 public void testEXE() {
 try {
 String cmd="C:\\Program Files\\Robo 3T 1.2.1\\robo3t.exe";
 // 创建一个本机进程
 Process p = Runtime.getRuntime().exec(cmd);

 // 等待 Process 执行完毕再继续向下运行
 //            p.waitFor();

 }catch (IOException ex) {
 ex.printStackTrace();
 }

 System.out.println("transfer finish");

 }

 @RequestMapping(value = "testlocal", method = RequestMethod.GET)
 public void testLocalEXE() {
 try {
 String cmd="D:\\Program Files\\Robo 3T 1.1.1\\robo3t.exe";
 // 创建一个本机进程
 Process p = Runtime.getRuntime().exec(cmd);

 // 等待 Process 执行完毕再继续向下运行
 //            p.waitFor();

 }catch (IOException ex) {
 ex.printStackTrace();
 }

 System.out.println("transfer finish");

 }
 */
}
