package com.iem.safety.iembackend.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findCustomerByOpenId(String openId);

    Customer findCustomerById(String id);

    Page<Customer> findAll(Pageable pageable);

}
