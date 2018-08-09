package com.baizhi.service;

import com.baizhi.entity.Log;

import java.util.List;

/**
 * Created by asus on 2018/8/5.
 */
public interface LogService {

    void addLog(Log log);

    List<Log> queryLogAll(int page,int rows);

    Integer logCount();

    List<Log> queryLog();
}
