package com.iem.safety.iembackend.superadmin;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-22 19:54
 */
public interface SuperAdminRepository extends MongoRepository<SuperAdmin, String> {
    SuperAdmin findSuperAdminByLoginAccount(String loginAccount);
}
