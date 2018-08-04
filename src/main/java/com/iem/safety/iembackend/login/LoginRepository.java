package com.iem.safety.iembackend.login;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-06-05 21:33
 */
public interface LoginRepository extends MongoRepository<Login, String> {
}
