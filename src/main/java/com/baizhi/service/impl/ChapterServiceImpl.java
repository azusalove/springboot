package com.baizhi.service.impl;

import com.baizhi.aspect.LogAnnotation;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Machenike on 2018/8/2.
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    @LogAnnotation(name = "添加章节")
    public void addChapter(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        chapter.setCreateDate(new Date(System.currentTimeMillis()));
        chapterDAO.addChapter(chapter);
    }
}
