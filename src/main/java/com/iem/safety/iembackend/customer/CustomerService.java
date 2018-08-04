package com.iem.safety.iembackend.customer;


import com.iem.safety.iembackend.group.Group;
import com.iem.safety.iembackend.group.GroupRepository;
import com.iem.safety.iembackend.utils.PageRequestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-01-08 15:58
 */
@Service
@SuppressWarnings("unused")
public class CustomerService {

    private final static String appid = "wx25e677e8947d91a8";
    private final static String secret = "3778faf90286e64c6bfa5dfc7f2a903c";

    private final CustomerRepository customerRepository;
    private final GroupRepository groupRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CustomerService(CustomerRepository customerRepository, GroupRepository groupRepository) {
        this.customerRepository = customerRepository;

        this.groupRepository = groupRepository;
    }


    public Map<String, Object> login(String code, HttpServletRequest request) throws IOException {
        logger.info("小程序登录code: " + code);
        Customer customer;
        Map<String, Object> map = new HashMap<>();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            String responseBody = httpClient.execute(httpGet, responseHandler);
            logger.info(responseBody);
            Document document = Document.parse(responseBody);
            customer = customerRepository.findCustomerByOpenId((String) document.get("openid"));
            if (customer == null) {
                customer = new Customer();
                customer.setId(new ObjectId().toString());
                customer.setOpenId((String) document.get("openid"));
            }
            request.getSession().setAttribute("_session_user", customer);
            request.getSession().setAttribute("_role", "normal");
            String sessionId = request.getSession().getId();

            map.put("sessionId", sessionId);
            map.put("customer", customer);
        }
        return map;
    }


    public Map<String, Object> suFindAll(int pageNumber, int pageSize) {

        PageRequest pr = PageRequestUtils.buildPageRequest(pageNumber, pageSize, "id");
        Page<Customer> res = customerRepository.findAll(pr);
        Map<String, Object> map = new HashMap<>();
        map.put("total", res.getTotalElements());
        map.put("rows", res.getContent());

        return map;

    }

    public List<Map<String, String>> adminFindByGroup(String earthquakeId) {
        List<Group> content = groupRepository.findGroupsByEarthquakeId(earthquakeId);
        List<Map<String, String>> mapList = new ArrayList<>();
        for (Group group : content) {
            Customer customer = customerRepository.findCustomerById(group.getCustomerId());
            Map<String, String> m = new HashMap<>();
            m.put("id", customer.getId());
            m.put("groupNumber", group.getGroupNumbering());
            m.put("isLeader", group.getIsLeader());
            m.put("name", customer.getName());
            m.put("profTitle", customer.getProfTitle());
            m.put("department", customer.getDepartment());
            m.put("discipline", customer.getDiscipline());
            m.put("phone", customer.getPhone());
            m.put("email", customer.getEmail());
            m.put("address", customer.getAddress());
            mapList.add(m);
        }


        return mapList;

    }
}
