package com.iem.safety.iembackend.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author MengQi 2018-06-05 21:33
 */
public interface NewsRepository extends MongoRepository<News, String> {
    void deleteNewsById(String id);

    Page<News> findNewsByNewsCategoryAndEarthquakeIdAndNewsTypeAndStatus(String category, String earthquakeId, String newsType, String status, Pageable pageable);

    Page<News> findNewsByAuthorIdAndEarthquakeIdAndNewsTypeAndStatus(String authorId, String earthquakeId, String newsType, String status, Pageable pageable);

    News findNewsById(String id);

    List<News> findNewsByEarthquakeIdAndNewsCategoryAndNewsTypeAndStatus(String category, String eid, String newType, String status);


    List<News> findNewsByEarthquakeIdAndNewsTypeAndStatus(String earthquakeId, String newsType, String status);
}
