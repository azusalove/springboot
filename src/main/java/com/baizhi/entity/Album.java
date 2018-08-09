package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * Created by Machenike on 2018/8/2.
 */
public class Album {

    private String id;
    private String title;
    private Integer score;
    private String author;
    private String broadcast;
    private Integer count;
    private String brief;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss ")
    private Date publishDate;
    private String coverImg;
    private Integer status;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss ")
    private Date createDate;

    private List<Chapter> children;

    public Album() {
    }

    public Album(String id, String title, Integer score, String author, String broadcast, Integer count, String brief, Date publishDate, String coverImg, Integer status, Date createDate, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.count = count;
        this.brief = brief;
        this.publishDate = publishDate;
        this.coverImg = coverImg;
        this.status = status;
        this.createDate = createDate;
        this.children = children;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
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

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", count=" + count +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", coverImg='" + coverImg + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", children=" + children +
                '}';
    }
}
