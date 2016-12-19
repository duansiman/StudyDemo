package com.devin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by devin on 2016/12/19.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload")
    public String uploadFile(MultipartHttpServletRequest request, @RequestParam(value = "filename") String filename){

        System.out.println(filename);

        // 获得文件：
        MultipartFile file = request.getFile("file");

        Iterator<String> fileNames = request.getFileNames();
        Map<String, MultipartFile> fileMap = request.getFileMap();
        while (fileNames.hasNext()) {
            String next = fileNames.next();
            System.out.println(next);
            MultipartFile multipartFile = fileMap.get(next);
            try {
                FileOutputStream fos = new FileOutputStream(new File("e:/", multipartFile.getOriginalFilename()));
                fos.write(multipartFile.getBytes());
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "success";
    }

}
