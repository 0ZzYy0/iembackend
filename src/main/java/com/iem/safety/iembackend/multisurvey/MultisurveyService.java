package com.iem.safety.iembackend.multisurvey;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MengQi 2018-01-08 15:58
 */
@Service
public class MultisurveyService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MultisurveyRepository repository;


    @Autowired
    public MultisurveyService(MultisurveyRepository repository) {
        this.repository = repository;
    }


}
