package com.iem.safety.iembackend.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MengQi 2018-05-22 19:54
 */
@RestController
@RequestMapping("account")
@SuppressWarnings(value = "unused")
public class AccountController {
    private final AccountRepository repository;
    private final AccountService service;

    public AccountController(AccountRepository repository, AccountService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Account create(@RequestParam("id") String id, @RequestParam("timestamp") long timestamp) {
        return service.create(id, timestamp);
    }
}
