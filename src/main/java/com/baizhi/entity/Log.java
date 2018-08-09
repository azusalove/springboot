package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baizhi.util.FiledName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by asus on 2018/8/5.
 */
public class Log implements Serializable {

    @FiledName(value = "编号")
    private String id;//操作编号
    @FiledName(value = "名字")
    private String username;//记录管理员的名字
    @FiledName(value = "操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;//记录管理员操作时间
    @FiledName(value = "操作记录")
    private String record;//操作的记录
    @FiledName(value = "操作结果")
    private String arg;//操作是否成功

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", createDate=" + createDate +
                ", record='" + record + '\'' +
                ", arg='" + arg + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public Log(String id, String username, Date createDate, String record, String arg) {

        this.id = id;
        this.username = username;
        this.createDate = createDate;
        this.record = record;
        this.arg = arg;
    }

    public Log() {

    }
}
