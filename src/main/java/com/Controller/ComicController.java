package com.Controller;

import com.annotation.UserLoginToken;
import com.pojo.Comic;
import com.service.ComicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * @date 2020/2/7 - 13:51
 */

@CrossOrigin
@RestController
public class ComicController {
    @Autowired
    ComicService comicService;



    @UserLoginToken
    @GetMapping("/api/books")
    public List<Comic> list(){
        return comicService.all();
    }


    @GetMapping("/api/categories/{cid}/books")
    public List<Comic> listbyid(@PathVariable("cid") int cid){
        return comicService.findbyCategory(cid);
    }



    @PostMapping("/api/admin/content/book")
    public Comic addcomic(@RequestBody Comic comic){
        comicService.AddOrUpdate(comic);
        return comic;
    }


    @PostMapping("/api/admin/content/books/delete")
    public Comic delete(@RequestBody Comic comic){
        comicService.delete(comic.getId());
        return comic;
    }


    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    @CrossOrigin
    @PostMapping("api/admin/content/books/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }



}
