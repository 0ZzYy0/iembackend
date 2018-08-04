package com.iem.safety.iembackend.login;

import com.iem.safety.iembackend.account.Account;
import com.iem.safety.iembackend.account.AccountRepository;
import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.Earthquake;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import com.iem.safety.iembackend.normaladmin.NormalAdmin;
import com.iem.safety.iembackend.normaladmin.NormalAdminRepository;
import com.iem.safety.iembackend.utils.MD5Utils;
import org.joda.time.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi 2018-06-05 21:33
 */
@Service
public class LoginService {
    private static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CustomerRepository customerRepository;
    private final LoginRepository repository;
    private final AccountRepository accountRepository;
    private final NormalAdminRepository normalAdminRepository;
    private final EarthquakeRepository earthquakeRepository;

    public LoginService(CustomerRepository customerRepository, LoginRepository repository, AccountRepository accountRepository, NormalAdminRepository normalAdminRepository, EarthquakeRepository earthquakeRepository) {
        this.customerRepository = customerRepository;
        this.repository = repository;
        this.accountRepository = accountRepository;
        this.normalAdminRepository = normalAdminRepository;
        this.earthquakeRepository = earthquakeRepository;
    }

    Customer loginCustomer(String loginAccount, long timestamp, String sign, HttpServletRequest request) {
        Account account = accountRepository.findAccountByLoginAccount(loginAccount);
        if (account == null) return null;
        Login login = new Login();
        login.setDateTime(new DateTime(timestamp).toString(DATETIME_FORMAT));
        login.setLoginAccount(loginAccount);
        login.setIp(request.getRemoteAddr());
        repository.insert(login);
        String encryption = (account.getLoginPassword() + timestamp);
        String md5Sign = MD5Utils.MD5(encryption);
        if (sign.equals(md5Sign)) {
            request.getSession().setAttribute("_role", "normal");
            request.getSession().setAttribute("_session_user", account);
            return customerRepository.findCustomerById(account.getCustomerId());
        } else return null;
    }

    public Earthquake loginAdmin(String loginAccount, long timestamp, String sign, HttpServletRequest request) {

        NormalAdmin normalAdmin = normalAdminRepository.findNormalAdminByLoginAccount(loginAccount);
        if (normalAdmin == null) return null;
        Login login = new Login();
        login.setDateTime(new DateTime(timestamp).toString(DATETIME_FORMAT));
        login.setLoginAccount(loginAccount);
        login.setIp(request.getRemoteAddr());
        repository.insert(login);
        String encryption = (normalAdmin.getLoginPassword() + timestamp);
        String md5Sign = MD5Utils.MD5(encryption);
        logger.info(md5Sign);
        if (sign.equals(md5Sign)) {
            request.getSession().setAttribute("_role", "admin");
            request.getSession().setAttribute("_session_user", normalAdmin);

            return earthquakeRepository.findEarthquakeById(normalAdmin.getEarthquakeId());
        } else return null;
    }
}
