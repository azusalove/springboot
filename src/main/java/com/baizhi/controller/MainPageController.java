package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Machenike on 2018/7/31.
 */
@Controller
public class MainPageController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/mainPage")
    public String mainPage(Map map) {
        List<Menu> menuList = menuService.showAll();
        map.put("menuList", menuList);
        return "main/main";
    }

}
