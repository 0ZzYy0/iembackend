package com.iem.safety.iembackend.news;

import org.springframework.data.annotation.Id;

/**
 * @author MengQi 2018-06-05 21:31
 */
@SuppressWarnings(value = "unused")
public class News {
    @Id
    private String id;

    private String newsBody;

    private String earthquakeId;
    private String status = "WORK";
    private String newsType;
    private String newsCategory;//COMMAND NORMAL
    private String newsTitle;
    private String newsContent;
    private String dateTime;
    private String lat;
    private String lng;
    private String address;
    private String authorName;
    private String authorGroup;
    private String authorDepartment;
    private String authorId;


    public News(String id, String newsBody, String earthquakeId, String status, String newsType, String newsCategory, String newsTitle, String newsContent, String dateTime, String lat, String lng, String address, String authorName, String authorGroup, String authorDepartment, String authorId) {
        this.id = id;
        this.newsBody = newsBody;
        this.earthquakeId = earthquakeId;
        this.status = status;
        this.newsType = newsType;
        this.newsCategory = newsCategory;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.dateTime = dateTime;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.authorName = authorName;
        this.authorGroup = authorGroup;
        this.authorDepartment = authorDepartment;
        this.authorId = authorId;
    }

    public News(String id, String newsBody, String earthquakeId, String newsType, String newsCategory, String newsTitle, String newsContent, String dateTime, String lat, String lng, String address, String authorName, String authorGroup, String authorDepartment, String authorId) {
        this.id = id;
        this.newsBody = newsBody;
        this.earthquakeId = earthquakeId;
        this.newsType = newsType;
        this.newsCategory = newsCategory;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.dateTime = dateTime;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.authorName = authorName;
        this.authorGroup = authorGroup;
        this.authorDepartment = authorDepartment;
        this.authorId = authorId;
    }

    public News() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEarthquakeId() {
        return earthquakeId;
    }

    public void setEarthquakeId(String earthquakeId) {
        this.earthquakeId = earthquakeId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorGroup() {
        return authorGroup;
    }

    public void setAuthorGroup(String authorGroup) {
        this.authorGroup = authorGroup;
    }

    public String getAuthorDepartment() {
        return authorDepartment;
    }

    public void setAuthorDepartment(String authorDepartment) {
        this.authorDepartment = authorDepartment;
    }


}
