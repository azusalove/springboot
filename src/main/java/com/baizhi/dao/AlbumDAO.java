package com.baizhi.dao;


import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Machenike on 2018/8/2.
 */
public interface AlbumDAO {
    List<Album> showAll();

    void addAlbum(Album album);
}
