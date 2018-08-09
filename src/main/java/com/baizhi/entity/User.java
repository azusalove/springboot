package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Machenike on 2018/8/5.
 */
public class User {
    private String id;
    private String name;
    private String dharma;
    private String photo;
    private String password;
    private String salt;
    private Integer sex;
    private String location;
    private String sign;
    private Integer status;
    private String phoneNum;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss ")
    private Date registDate;

    public User() {
    }

    public User(String id, String name, String dharma, String photo, String password, String salt, Integer sex, String location, String sign, Integer status, String phoneNum, Date registDate) {
        this.id = id;
        this.name = name;
        this.dharma = dharma;
        this.photo = photo;
        this.password = password;
        this.salt = salt;
        this.sex = sex;
        this.location = location;
        this.sign = sign;
        this.status = status;
        this.phoneNum = phoneNum;
        this.registDate = registDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharma() {
        return dharma;
    }

    public void setDharma(String dharma) {
        this.dharma = dharma;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dharma='" + dharma + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", sex=" + sex +
                ", location='" + location + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", phoneNum='" + phoneNum + '\'' +
                ", registDate=" + registDate +
                '}';
    }
}
