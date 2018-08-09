package com.baizhi.service.impl;

import com.baizhi.dao.LogDao;
import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/8/5.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    @Override
    public void addLog(Log log) {

        logDao.insertLog(log);
    }

    @Override
    public List<Log> queryLogAll(int page, int rows) {
        return logDao.serlectLogAll((page-1)*rows,rows);
    }

    @Override
    public Integer logCount() {
        return logDao.LogCount();
    }

    @Override
    public List<Log> queryLog() {
        return logDao.selectLog();
    }
}
