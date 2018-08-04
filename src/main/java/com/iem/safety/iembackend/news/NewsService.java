package com.iem.safety.iembackend.news;

import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-06-05 21:33
 */
@Service
public class NewsService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final NewsRepository repository;
    private final MongoTemplate template;

    public NewsService(NewsRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    List<Map<String, Object>> getByCategory(String category, int pageNumber, String authorId, String earthquakeId, String newsType) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pr = PageRequest.of(pageNumber, 10, sort);
        if (category.equals("MY")) {
            return formatPageResult(repository.findNewsByAuthorIdAndEarthquakeIdAndNewsTypeAndStatus(authorId, earthquakeId, newsType, "WORK", pr));
        }
        return formatPageResult(repository.findNewsByNewsCategoryAndEarthquakeIdAndNewsTypeAndStatus(category, earthquakeId, newsType, "WORK", pr));
    }


    private List<Map<String, Object>> formatPageResult(Page<News> page) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (News news : page) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", news.getId());
            map.put("authorName", news.getAuthorName());
            map.put("dateTime", news.getDateTime());
            map.put("newsTitle", news.getNewsTitle());
            list.add(map);
        }
        return list;
    }

    List<News> getByCategoryEidNewType(String eid, String nty, String category) {
        List<News> list = repository.findNewsByEarthquakeIdAndNewsCategoryAndNewsTypeAndStatus(eid, category, nty, "WORK");
        list.forEach(news -> {
            news.setNewsContent(null);
            news.setAuthorDepartment(null);
            news.setLat(null);
            news.setLng(null);
            news.setAuthorGroup(null);
        });
        return list;
    }

    public void setDel(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));
        Update update = new Update();
        update.set("status", "DEL");
        template.updateFirst(query, update, News.class);

    }

    List<News> getByEIdAndType(String eid, String newsType) {
        List<News> res = repository.findNewsByEarthquakeIdAndNewsTypeAndStatus(eid, newsType, "WORK");
        for (News re : res) {
            re.setNewsContent(null);
        }
        return res;
    }
}
