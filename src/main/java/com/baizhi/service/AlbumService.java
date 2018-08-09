package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Machenike on 2018/8/2.
 */
public interface AlbumService {
    List<Album> showAll();

    void addAlbum(Album album);
}
