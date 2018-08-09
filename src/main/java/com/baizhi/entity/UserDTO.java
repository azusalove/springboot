package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Machenike on 2018/8/8.
 */
public class UserDTO {
    @JSONField(name = "name")
    private String location;
    @JSONField(name = "value")
    private Integer count;

    public UserDTO() {
    }

    public UserDTO(String location, Integer count) {
        this.location = location;
        this.count = count;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "location='" + location + '\'' +
                ", count=" + count +
                '}';
    }
}
