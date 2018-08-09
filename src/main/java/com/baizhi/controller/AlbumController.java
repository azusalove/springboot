package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Machenike on 2018/8/2.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Object showAll() {
        return albumService.showAll();
    }

    @RequestMapping("/download")
    public void download(HttpSession session, HttpServletResponse response, String title, String url) {
        //章节下载
        FileOperation.download(session, response, title, url, "audio");
    }

    @RequestMapping("/addChapter")
    @ResponseBody
    public void addChapter(Chapter chapter, HttpSession session, MultipartFile audio) {
        String newName = FileOperation.upload(session, "audio", audio);
        chapter.setUrl(newName);
        chapterService.addChapter(chapter);
    }

    @RequestMapping("/addAlbum")
    @ResponseBody
    public void addAlbum(Album album, HttpSession session, MultipartFile img) {
        String newName = FileOperation.upload(session, "upload", img);
        album.setCoverImg(newName);
        albumService.addAlbum(album);
    }

}
