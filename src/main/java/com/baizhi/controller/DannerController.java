package com.baizhi.controller;

import com.baizhi.entity.Danner;
import com.baizhi.service.DannerService;
import com.baizhi.util.FileOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Machenike on 2018/7/31.
 */
@Controller
@RequestMapping("/danner")
public class DannerController {
    @Autowired
    private DannerService dannerService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Object showAll(int page, int rows) {
        int start = (page - 1) * rows;
        int end = page * rows;
        List<Danner> dannerList = dannerService.showAll(start, end);
        Integer total = dannerService.count();
        Map map = new HashMap();
        map.put("total", total);
        map.put("rows", dannerList);
        return map;
    }

    @ResponseBody
    @RequestMapping("/addDanner")
    public void addBanner(String title, Integer status, String desc, MultipartFile img, HttpSession session) {
        String newFileName = FileOperation.upload(session, "upload", img);
        //数据库写入开始
        Danner danner = new Danner();
        danner.setDescription(desc);
        danner.setTitle(title);
        danner.setStatus(status);
        danner.setUrl("/upload/" + newFileName);
        dannerService.insert(danner);
        //数据库写入结束

    }

    @ResponseBody
    @RequestMapping("/deleteDanner")
    public void delete(String id) {
        dannerService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/updateDanner")
    public void update(Danner danner) {
        dannerService.update(danner);
    }
}
