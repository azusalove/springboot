package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import com.baizhi.util.FiledName;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2018/8/5.
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String, Object> getLogAll(int page, int rows, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<Log> list = logService.queryLogAll(page, rows);
        session.setAttribute("logs", list);
        Integer count = logService.logCount();

        map.put("rows", list);
        map.put("total", count);

        return map;

    }

    /**
     * 导出文件（excel）
     * @param response
     * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public Map<String, Object> export(HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            //创建excel对象
            HSSFWorkbook workbook = new HSSFWorkbook();
            //设置日期格式
            HSSFDataFormat dataFormat = workbook.createDataFormat();
            short format = dataFormat.getFormat("yyyy-MM-dd HH:mm:ss");

            //设置表的名字
            HSSFSheet sheet = workbook.createSheet("excel");
            sheet.setColumnWidth(2, 20 * 256);

            //创建样式
            CellStyle cellStyle = workbook.createCellStyle();
            //然后在将设置好的单元格放入样式中
            cellStyle.setDataFormat(format);
            //创建行
            Row row = sheet.createRow(0);
            //
            Class<Log> logClass = Log.class;
            //
            Field[] declaredFields = logClass.getDeclaredFields();
            //
            for (int i = 0; i < declaredFields.length; i++) {
                FiledName annotation = declaredFields[i].getAnnotation(FiledName.class);
                String value = annotation.value();
                //创建行并把数据存进行中
                row.createCell(i).setCellValue(value);
            }

            List<Log> list = logService.queryLog();
            for (int i = 0; i < list.size(); i++) {
                HSSFRow row1 = sheet.createRow(i + 1);
                row1.createCell(0).setCellValue(list.get(i).getId());
                row1.createCell(1).setCellValue(list.get(i).getUsername());
                //因为有日期，还有对日期要进行处理
                Cell cell = row1.createCell(2);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(list.get(i).getCreateDate());

                row1.createCell(3).setCellValue(list.get(3).getRecord());
            }

            String ab = "log.xls";
            String newName = new String(ab.getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("Content-Disposition","attachment;fileName="+newName);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());

            map.put("message","导出成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","导出失败");
        }
        return map;
    }
}
