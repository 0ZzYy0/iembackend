package com.iem.safety.iembackend.news;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author MengQi 2018-06-05 21:32
 */
@RestController
@RequestMapping("news")
@SuppressWarnings(value = "unused")
public class NewsController {


    private final NewsService service;

    private final NewsRepository repository;

    public NewsController(NewsService service, NewsRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public News add(@RequestBody News news) {
        return repository.insert(news);
    }

    @RequestMapping(value = "del", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") String id) {
        service.setDel(id);
    }


    @RequestMapping(value = "getByCategory", method = RequestMethod.GET)
    public List<Map<String, Object>> getByCategory(@RequestParam("category") String category,
                                                   @RequestParam("pageNumber") int pageNumber,
                                                   @RequestParam("authorId") String authorId,
                                                   @RequestParam("earthquakeId") String earthquakeId,
                                                   @RequestParam("newsType") String newsType) {
        return service.getByCategory(category, pageNumber, authorId, earthquakeId, newsType);
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public News getById(@RequestParam("id") String id) {
        return repository.findNewsById(id);
    }


    @RequestMapping(value = "admin/getbyeidandc", method = RequestMethod.GET)
    public List<News> getByCategoryEidNewType(@RequestParam("eid") String eid,
                                              @RequestParam("nty") String nty,
                                              @RequestParam("category") String category) {
        return service.getByCategoryEidNewType(eid, nty, category);
    }


    @RequestMapping(value = "getByEIdAndType", method = RequestMethod.GET)
    public List<News> getByEIdAndType(@RequestParam("eid") String eid,
                                      @RequestParam("newsType") String newsType) {
        return service.getByEIdAndType(eid, newsType);
    }


}
