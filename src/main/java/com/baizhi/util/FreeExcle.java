package com.baizhi.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by Machenike on 2018/8/3.
 */
public class FreeExcle {

    private static Workbook workbook = new HSSFWorkbook();
    private static CellStyle cellStyle;
    private static CellStyle dateCellStyle;

    public FreeExcle() {

        cellStyle = workbook.createCellStyle();
        dateCellStyle = workbook.createCellStyle();

        //单元格
        //字体
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        font.setFontName("楷体");
        font.setBold(true);

        //设置文字及单元格样式
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //时间格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("YYYY年MM月dd日");
        dateCellStyle.setDataFormat(format);
    }

    public static void export(HttpServletResponse response, String[] titles, String[] fields, List<?> resource, Class<?> clazz) {
        //创建sheet对象
        Sheet sheet = workbook.createSheet("sheet1");

        //创建表头行
        Row row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title);
            //设置列宽
            sheet.setColumnWidth(i, 30 * 256);
        }
        //数据操作
        for (int i = 0; i < resource.size(); i++) {
            Row textRow = sheet.createRow(i + 1);
            for (int j = 0; j < fields.length; j++) {
                //首字母大写
                //获取属性的get方法
                String methodName = "get" + fields[j].substring(0, 1).toUpperCase() + fields[j].substring(1);
                Object obj = null;
                try {
                    //调用get方法并获得返回值
                    obj = clazz.getDeclaredMethod(methodName, null).invoke(resource.get(i), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (obj instanceof Date) {
                    sheet.setColumnWidth(j, 30 * 256);
                    Cell cell = textRow.createCell(j);
                    cell.setCellStyle(dateCellStyle);
                    cell.setCellValue((Date) obj);
                } else {
                    textRow.createCell(j).setCellValue(String.valueOf(obj));
                }

            }

        }
        //从浏览器下载
        String newName = new Date().getTime() + "";
        newName = newName + "用户数据" + ".xls";
        String httpName = null;
        try {
            httpName = new String(newName.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-Disposition", "attachment;fileName=" + httpName);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*public static List<?> excleImport(MultipartFile file,Class<?> clazz) {
        Workbook workbookIn = null;
        try {
            workbookIn = new HSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbookIn.getSheet("sheet1");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);



            Cell cell = row.getCell(0);
            String id = cell.getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            Date bir = row.getCell(3).getDateCellValue();
            User user = new User(id, name, password, bir);
            users.add(user);
        }
        for (User user : users) {
            System.out.println(user);
        }
    }*/

}
