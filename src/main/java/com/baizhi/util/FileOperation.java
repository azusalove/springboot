package com.baizhi.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Created by Machenike on 2018/8/2.
 */
public class FileOperation {
    public static String upload(HttpSession session, String uploadPath, MultipartFile uploadFile) {
        //上传文件开始
        //获取项目绝对路径
        String projectPath = session.getServletContext().getRealPath("/");
        uploadPath = projectPath + uploadPath;
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //获取文件名及后缀
        String originalFilename = uploadFile.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        //重组文件名
        String uuid = UUID.randomUUID().toString();
        String newName = uuid + "." + extension;
        //保存文件
        try {
            uploadFile.transferTo(new File(uploadPath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return newName;
        }
        //file.length();
        //上传文件结束
    }

    public static void download(HttpSession session, HttpServletResponse response, String downloadName, String url, String uploadPath) {

        String realPath = session.getServletContext().getRealPath("/");

        uploadPath = realPath + uploadPath;

        String filePath = uploadPath + "/" + url;

        File file = new File(filePath);

        String extension = FilenameUtils.getExtension(url);

        downloadName = downloadName + "." + extension;

        String newName = null;

        try {
            newName = new String(downloadName.getBytes("utf-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setContentType("audio/mpeg");
        response.setHeader("content-Disposition", "attachment;fileName=" + newName);

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
