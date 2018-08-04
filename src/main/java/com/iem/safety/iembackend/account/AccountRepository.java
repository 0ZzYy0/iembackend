package com.iem.safety.iembackend.account;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findAccountByCustomerId(String customerId);

    Account findAccountByLoginAccount(String loginAccount);
}
