package com.ehome.spring_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by xiaolei on 2015-03-21 10:18
 */
@Controller
@RequestMapping("file")
public class UploadDownloadController {

    @RequestMapping("/download{fileName}")
    public String download(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        OutputStream os = null;
        InputStream inputStream = null;

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        try {
            //String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "download";//这个download目录为啥建立在classes下的
            String path = "G:\\Setup\\开发工具";
            inputStream = new FileInputStream(new File(path + File.separator + fileName));

            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 这里主要关闭。
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }


}
