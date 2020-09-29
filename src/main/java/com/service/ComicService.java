package com.service;

import com.dao.ComicMapper;
import com.pojo.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/2/7 - 13:29
 */
@Service
public class ComicService {

    @Autowired
    ComicMapper comicMapper;


    public List<Comic> all(){
        return comicMapper.findall();
    }

    public Comic findbyid(int id){
        return comicMapper.getComicbyId(id);
    }

    public void AddOrUpdate(Comic comic){
        Comic comicbytitle = comicMapper.getComicbytitle(comic.getTitle());
        //System.out.println(comicbytitle.getCid());
        if(comicbytitle!=null){
            comicMapper.UpdateComic(comic);
        }
        else{
            comicMapper.AddComic(comic);
        }
    }

    public List<Comic> findbyCategory(int cid) {
        if(cid==0){
            return comicMapper.findall();
        }
        else{
            return comicMapper.findbyCategory(cid);
        }
    }

    public void delete(int id){
        comicMapper.DeletebyID(id);
    }



}
