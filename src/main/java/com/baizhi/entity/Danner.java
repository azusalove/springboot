package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Machenike on 2018/7/31.
 */
public class Danner {
    private String id;
    private String title;
    private String url;
    private Integer status;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss ")
    private Date createDate;
    private String description;

    public Danner() {
    }

    public Danner(String id, String title, String url, Integer status, Date createDate, String description) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.status = status;
        this.createDate = createDate;
        this.description = description;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Danner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                '}';
    }
}
