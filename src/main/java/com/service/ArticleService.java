package com.service;

import com.dao.ArticleMappper;
import com.github.pagehelper.PageHelper;
import com.pojo.Article;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @date 2020/2/18 - 14:31
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMappper articleMappper;

    @Autowired
    TokenService tokenService;

    public void AddOrUpdate(Article article, HttpServletRequest httpServletRequest){
        int uid = tokenService.getUser(httpServletRequest).getId();
        Article articlebytitle = articleMappper.getArticlebytitle(article);
        Date date = new Date();//获得系统时间. 
        article.setArticleDate(date);
        if(articlebytitle!=null){
            article.setUid(uid);
            articleMappper.UpdateArticle(article);
        }
        else{
            //System.out.println(uid);
            article.setUid(uid);
            articleMappper.Addarticle(article);
        }
    }

    public List<Article> list(int page,int size,HttpServletRequest httpServletRequest){
        int uid = tokenService.getUser(httpServletRequest).getId();
        PageHelper.startPage(page,size);
        return articleMappper.getall(uid);
    }

    public List<Article> listbyabstract(int page,int size,HttpServletRequest httpServletRequest,String abstrac){
        int uid = tokenService.getUser(httpServletRequest).getId();
        PageHelper.startPage(page,size);
        Article article = new Article();
        article.setUid(uid);
        article.setAbstract(abstrac);
        return articleMappper.getbyabstract(article);
    }


    public void  delete(int id,HttpServletRequest httpServletRequest){
        int uid = tokenService.getUser(httpServletRequest).getId();
        articleMappper.DeletebyID(id,uid);
    }

    public Article getbyId(int id,HttpServletRequest httpServletRequest){
        int uid = tokenService.getUser(httpServletRequest).getId();
        return articleMappper.getArticlebyId(id,uid);
    }

    public HashMap<String,Integer> getcoverandnum(HttpServletRequest httpServletRequest){
        int uid = tokenService.getUser(httpServletRequest).getId();
        List<Article> articles = articleMappper.getall(uid);
        ListIterator<Article>listIterator = articles.listIterator();
        HashMap<String,Integer>vis = new HashMap<>();
        while(listIterator.hasNext()){
            String abstrac = listIterator.next().getAbstract();
            if(vis.containsKey(abstrac)){
                vis.put(abstrac,vis.get(abstrac)+1);
            }
            else vis.put(abstrac,1);
        }
        return vis;
    }

    public ArrayList<String> getcover(HttpServletRequest httpServletRequest){
        HashMap<String,Integer>vis = getcoverandnum(httpServletRequest);
        Iterator iterator = vis.entrySet().iterator();
        ArrayList<String>abstracs = new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if(entry.getKey()==null) continue;
            abstracs.add((String) entry.getKey());
        }
        return abstracs;
    }

    public ArrayList<Integer> getcovernum(HttpServletRequest httpServletRequest){
        HashMap<String,Integer>vis = getcoverandnum(httpServletRequest);
        Iterator iterator = vis.entrySet().iterator();
        ArrayList<Integer>nums = new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if(entry.getKey()==null) continue;
            nums.add((Integer)entry.getValue());
        }
        return nums;
    }

    public User getusername(HttpServletRequest httpServletRequest){
        return tokenService.getUser(httpServletRequest);
    }
}
