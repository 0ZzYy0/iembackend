package com.iem.safety.iembackend.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-01-08 15:58
 */
@RestController
@RequestMapping("customer")
@SuppressWarnings(value = "unused")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerRepository customerRepository,
                              CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestParam("code") String code, HttpServletRequest request) throws IOException {
        return customerService.login(code, request);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Customer update(@RequestBody Customer customer, HttpServletRequest request) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "su/FindAll", method = RequestMethod.GET)
    public Map<String, Object> suFindAll(@RequestParam("pageNumber") int pageNumber,
                                         @RequestParam("pageSize") int pageSize) {
        return customerService.suFindAll(pageNumber, pageSize);

    }

    @RequestMapping(value = "admin/FindByGroup", method = RequestMethod.GET)
    public List<Map<String, String>> adminFindByGroup(@RequestParam("earthquakeId") String earthquakeId
    ) {
        return customerService.adminFindByGroup(earthquakeId);
    }
}
