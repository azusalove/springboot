package com.baizhi.dao;

import com.baizhi.entity.Danner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Machenike on 2018/7/31.
 */
public interface DannerDAO {
    List<Danner> showAll(@Param("start") int start, @Param("end") int end);

    Integer count();

    void insert(Danner danner);

    void delete(String id);

    void update(Danner danner);

}
