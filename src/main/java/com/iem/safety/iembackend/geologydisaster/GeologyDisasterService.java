package com.iem.safety.iembackend.geologydisaster;

import com.iem.safety.iembackend.customer.CustomerRepository;
import com.iem.safety.iembackend.earthquake.EarthquakeRepository;
import com.iem.safety.iembackend.group.GroupRepository;
import com.iem.safety.iembackend.multisurvey.MultisurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author zy 2018-01-08 15:58
 */
@Service
public class GeologyDisasterService {

    private final static String rootPath = System.getProperty("user.dir");
    private final static String fileDir = System.getProperty("user.dir") + File.separator + "static";


    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EarthquakeRepository earthquakeRepository;
    private final GeologyDisasterRepository repository;
    private final GroupRepository groupRepository;
    private final CustomerRepository customerRepository;
    private final MultisurveyRepository multisurveyRepository;

    @Autowired
    public GeologyDisasterService(EarthquakeRepository earthquakeRepository, GeologyDisasterRepository repository, GroupRepository groupRepository, CustomerRepository customerRepository, MultisurveyRepository multisurveyRepository) {
        this.earthquakeRepository = earthquakeRepository;
        this.repository = repository;
        this.groupRepository = groupRepository;
        this.customerRepository = customerRepository;
        this.multisurveyRepository = multisurveyRepository;
    }
}
