package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Machenike on 2018/8/2.
 */
public class Chapter {
    private String id;
    private String title;
    private String url;
    private String size;
    private String duration;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss ")
    private Date createDate;
    private String albumId;

    public Chapter() {
    }

    public Chapter(String id, String title, String url, String size, String duration, Date createDate, String albumId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.createDate = createDate;
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", createDate=" + createDate +
                ", albumId='" + albumId + '\'' +
                '}';
    }
}
