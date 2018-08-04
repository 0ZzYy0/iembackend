package com.iem.safety.iembackend.singlesurvey;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi 2018-05-04 15:58
 */
public interface SinglesurveyRepository extends MongoRepository<Singlesurvey, String> {

    List<Singlesurvey> findByOwnerIdAndSurveyId(String ownerId, String surveyId);

    List<Singlesurvey> findByOwnerIdAndAssessedAndEarthquakeId(String ownerId, boolean assessed, String earthquakeId);

    List<Singlesurvey> findByOwnerIdAndSurveyUuid(String ownerId, String surveyId);

}
