package com.baizhi.dao;

import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus on 2018/8/5.
 */
@Repository
public interface LogDao {

    void insertLog(Log log);

    List<Log> serlectLogAll(@Param("start") int start, @Param("end") int end);

    Integer LogCount();

    List<Log> selectLog();//这是无效功能
}
