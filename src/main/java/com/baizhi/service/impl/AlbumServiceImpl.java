package com.baizhi.service.impl;

import com.baizhi.aspect.LogAnnotation;
import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Machenike on 2018/8/2.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public List<Album> showAll() {
        return albumDAO.showAll();
    }

    @Override
    @LogAnnotation(name = "添加专辑")
    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        album.setCreateDate(new Date(System.currentTimeMillis()));
        albumDAO.addAlbum(album);
    }
}
