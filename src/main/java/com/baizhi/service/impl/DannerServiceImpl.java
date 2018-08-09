package com.baizhi.service.impl;

import com.baizhi.aspect.LogAnnotation;
import com.baizhi.dao.DannerDAO;
import com.baizhi.entity.Danner;
import com.baizhi.service.DannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Machenike on 2018/7/31.
 */
@Service
public class DannerServiceImpl implements DannerService {
    @Autowired
    private DannerDAO dannerDAO;

    @Override
    public List<Danner> showAll(int start, int end) {
        return dannerDAO.showAll(start, end);
    }

    @Override
    public Integer count() {
        return dannerDAO.count();
    }

    @Override
    @LogAnnotation(name = "添加轮播图")
    public void insert(Danner danner) {
        danner.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        danner.setCreateDate(new Date(System.currentTimeMillis()));
        dannerDAO.insert(danner);
    }

    @Override
    @LogAnnotation(name = "删除轮播图")
    public void delete(String id) {
        dannerDAO.delete(id);
    }

    @Override
    @LogAnnotation(name = "修改轮播图")
    public void update(Danner danner) {
        dannerDAO.update(danner);
    }
}
