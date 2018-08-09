package com.baizhi.service;

import com.baizhi.entity.Danner;

import java.util.List;

/**
 * Created by Machenike on 2018/7/31.
 */
public interface DannerService {
    List<Danner> showAll(int start, int end);

    Integer count();

    void insert(Danner danner);

    void delete(String id);

    void update(Danner danner);

}
