package com.Controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.UserLoginToken;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Article;
import com.pojo.paging;
import com.result.Result;
import com.result.ResultFactory;
import com.service.ArticleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

/**
 * @date 2020/2/18 - 14:35
 */
@CrossOrigin
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @UserLoginToken
    @PostMapping("api/admin/content/article")
    public Result add(@RequestBody Article article,HttpServletRequest httpServletRequest){
        //System.out.println(article.toString());
        articleService.AddOrUpdate(article,httpServletRequest);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    @UserLoginToken
    @GetMapping("/api/article/{size}/{page}")
    public Result listArticles(@PathVariable("page") int page, @PathVariable("size") int size,HttpServletRequest httpServletRequest) {
        Page p = PageHelper.startPage(page , size);
        PageInfo<Article>pageInfo = new PageInfo<>(articleService.list(page,size,httpServletRequest));
        return ResultFactory.buildSuccessResult(new paging((List<Article>) pageInfo.getList(),pageInfo.getTotal()));
    }

    @UserLoginToken
    @DeleteMapping("/api/admin/content/article/{id}")
    public Result deleteArticle(@PathVariable("id") int id,HttpServletRequest httpServletRequest) {
        articleService.delete(id,httpServletRequest);
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @GetMapping("/api/article/{id}")
    public Result getarticlebyid(@PathVariable("id")int id,HttpServletRequest httpServletRequest){
        return ResultFactory.buildSuccessResult(articleService.getbyId(id,httpServletRequest));
    }

    @GetMapping("/api/article/userinformation/Abstract")
    public Result getuserinformation(HttpServletRequest httpServletRequest){
        return ResultFactory.buildSuccessResult(articleService.getcover(httpServletRequest));
    }

    @GetMapping("/api/article/userinformation/username")
    public Result getusername(HttpServletRequest httpServletRequest){
        return ResultFactory.buildSuccessResult(articleService.getusername(httpServletRequest));
    }

    @GetMapping("/api/article/Abstract/num")
    public Result getcovernum(HttpServletRequest httpServletRequest){
        return ResultFactory.buildSuccessResult(articleService.getcovernum(httpServletRequest));
    }

    @GetMapping("/api/article/Abstract/{Abstractencode}/{size}/{page}")
    public Result ListAbstract(@PathVariable("Abstractencode") String Abstractencode,@PathVariable("size") int size,@PathVariable("page") int page,HttpServletRequest httpServletRequest){
        String Abstract = "";
        byte [] data = Base64.getDecoder().decode(Abstractencode);
        try {
            Abstract = new String(data,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Page p = PageHelper.startPage(page,size);
        PageInfo<Article>pageInfo = new PageInfo<>(articleService.listbyabstract(page,size,httpServletRequest,Abstract));
        return ResultFactory.buildSuccessResult(new paging((List<Article>) pageInfo.getList(),pageInfo.getTotal()));
    }

}
