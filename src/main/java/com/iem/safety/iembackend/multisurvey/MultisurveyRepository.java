package com.iem.safety.iembackend.multisurvey;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi 2018-05-04 15:58
 */
public interface MultisurveyRepository extends MongoRepository<Multisurvey, String> {

    Multisurvey findByOwnerIdAndSurveyUuid(String ownerId, String surveyUuid);

    Multisurvey findMultisurveyBySurveyId(String surveyId);

    Multisurvey findMultisurveyBySurveyUuid(String surveyUuid);
}
