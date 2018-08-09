package com.baizhi.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Machenike on 2018/8/1.
 */
@Controller
public class KaptchaController {

    @Autowired
    private Producer producer;

    @RequestMapping("/kaptcha.jpg")
    public void captcha(HttpServletResponse response, HttpSession session) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        session.setAttribute("kaptcha_enCode", text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @RequestMapping("/kaptchaCheck")
    @ResponseBody
    public Object check(String enCode, HttpSession session) {

        String text = (String) session.getAttribute("kaptcha_enCode");
        if (enCode != null && text != null && enCode.equals(text)) {
            return true;
        } else {
            return false;
        }
    }
}
