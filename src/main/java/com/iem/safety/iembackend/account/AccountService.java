package com.iem.safety.iembackend.account;

import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.customer.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * @author MengQi 2018-05-22 19:55
 */
@Service
public class AccountService {


    private final CustomerRepository customerRepository;

    private final AccountRepository repository;

    public AccountService(CustomerRepository customerRepository, AccountRepository repository) {
        this.customerRepository = customerRepository;
        this.repository = repository;
    }

    Account create(String id, long timestamp) {
        Account account = repository.findAccountByCustomerId(id);
        if (account != null) return account;
        account = new Account();
        Customer customer = customerRepository.findCustomerById(id);

        account.setOpenId(customer.getOpenId());
        account.setCustomerId(id);
        account.setTimestamp(timestamp);
        account.setId(new ObjectId().toString());
        account.setLoginAccount(customer.getEmail() + "_" + Integer.toHexString(customer.getPhone().hashCode() << 1 + 1));
        account.setLoginPassword(Integer.toHexString(customer.getEmail().hashCode() << 1 + 1));
        return repository.save(account);
    }
}
