package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.FreeExcle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Machenike on 2018/8/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Object showAll() {
        return userService.showAll();
    }

    @RequestMapping("/multiAdd")
    @ResponseBody
    public void multiAdd(MultipartFile file) {
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheet("sheet1");
        List<User> userList = new ArrayList<User>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            User user = new User();
            Row row = sheet.getRow(i);
            user.setId(row.getCell(0).getStringCellValue());
            user.setName(row.getCell(1).getStringCellValue());
            user.setPassword(row.getCell(2).getStringCellValue());
            user.setRegistDate(row.getCell(3).getDateCellValue());
            userList.add(user);
        }
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @RequestMapping("/download")
    @ResponseBody
    public void showAll(HttpServletResponse response) {
        String[] names = {"id", "name", "password", ""};
        String[] fields = {"id", "name", "password", "registDate"};
        List<User> userList = userService.showAll();
        FreeExcle.export(response, names, fields, userList, User.class);
    }

    @RequestMapping("/freeze")
    @ResponseBody
    public void freeze(String id) {
        userService.freeze(id);
    }

    @RequestMapping("/active")
    @ResponseBody
    public void active(String id) {
        userService.active(id);
    }

    @RequestMapping("/showUserMapCountBySex")
    @ResponseBody
    public JSONObject showUserMapCountBySex() {
        JSONObject jsonObject = userService.queryUserMapCount();
        return jsonObject;
    }
}
