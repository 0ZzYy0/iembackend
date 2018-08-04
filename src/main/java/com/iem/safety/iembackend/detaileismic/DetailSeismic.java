package com.iem.safety.iembackend.detaileismic;

import com.iem.safety.iembackend.fileEntity.FileEntity;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * 细部震损
 *
 * @author MengQi 2018-06-20 21:22
 */
public class DetailSeismic {
    @Id
    private String id;

    private String assessId;

    private String customerId;
    private String intuitJudgement;//判断结果
    private boolean intuited;//是否直观
    private List<String> audios = new ArrayList<>();
    private List<String> images = new ArrayList<>();
    private List<String> videos = new ArrayList<>();
    private List<FileEntity> imageList = new ArrayList<>();
    private List<FileEntity> videoList = new ArrayList<>();
    private List<FileEntity> audioList = new ArrayList<>();

    public DetailSeismic(String id, String assessId, String customerId, String intuitJudgement, boolean intuited, List<String> audios, List<String> images, List<String> videos, List<FileEntity> imageList, List<FileEntity> videoList, List<FileEntity> audioList) {
        this.id = id;
        this.assessId = assessId;
        this.customerId = customerId;
        this.intuitJudgement = intuitJudgement;
        this.intuited = intuited;
        this.audios = audios;
        this.images = images;
        this.videos = videos;
        this.imageList = imageList;
        this.videoList = videoList;
        this.audioList = audioList;
    }

    public DetailSeismic() {
    }

    public String getIntuitJudgement() {
        return intuitJudgement;
    }

    public void setIntuitJudgement(String intuitJudgement) {
        this.intuitJudgement = intuitJudgement;
    }

    public boolean isIntuited() {
        return intuited;
    }

    public void setIntuited(boolean intuited) {
        this.intuited = intuited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getAudios() {
        return audios;
    }

    public void setAudios(List<String> audios) {
        this.audios = audios;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<FileEntity> getImageList() {
        return imageList;
    }

    public void setImageList(List<FileEntity> imageList) {
        this.imageList = imageList;
    }

    public List<FileEntity> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<FileEntity> videoList) {
        this.videoList = videoList;
    }

    public List<FileEntity> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<FileEntity> audioList) {
        this.audioList = audioList;
    }


}
