package com.Controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.UserLoginToken;
import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.TokenService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * @date 2020/2/5 - 13:26
 */
@CrossOrigin
@RestController
//@RequestMapping("api")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;



    @PostMapping(value = "api/login")
    public Result login(@RequestBody User user) {
        User userForBase=userService.getbyname(user.getUsername());
        //System.out.println(user.getUsername());
        if(userForBase==null){
            return ResultFactory.buildFailResult("用户不存在");
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                return ResultFactory.buildFailResult("登录失败,密码错误");
            }else {

                String token = tokenService.getToken(userForBase);
                return ResultFactory.buildSuccessResult(token);
            }
        }
    }


    @GetMapping(value = "api/logout")
    public Result logout(){
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }


    @PostMapping("/api/register")
    public Result register(@RequestBody User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
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
    @PostMapping("api/register/cover")
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
            //System.out.println(imgURL);
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }



}
