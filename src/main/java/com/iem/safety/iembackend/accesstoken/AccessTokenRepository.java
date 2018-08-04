package com.iem.safety.iembackend.accesstoken;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-02-18 19:02
 */
public interface AccessTokenRepository extends MongoRepository<AccessToken, String> {
    AccessToken findAccessTokenByTimestampGreaterThan(long timestamp);
}
