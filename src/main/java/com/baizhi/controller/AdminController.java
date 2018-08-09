package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Machenike on 2018/7/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpSession session) {
        Admin result = adminService.login(admin);
        if (result == null) {
            return "redirect:/login.jsp";
        } else {
            session.setAttribute("isLogin", result);
            return "redirect:/mainPage";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("isLogin", null);
        return "redirect:/login.jsp";
    }

}
