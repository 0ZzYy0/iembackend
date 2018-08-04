package com.iem.safety.iembackend.normaladmin;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author MengQi 2018-06-05 21:33
 */
public interface NormalAdminRepository extends MongoRepository<NormalAdmin, String> {
    NormalAdmin findNormalAdminByLoginAccount(String loginAccount);

    List<NormalAdmin> findNormalAdminsByEarthquakeId(String eid);

    NormalAdmin findNormalAdminById(String id);
}
