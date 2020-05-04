package com.dao;

import com.pojo.Comic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/2/7 - 13:10
 */
@Mapper
public interface ComicMapper {
    public Comic getComicbyId(@Param("id") int id);

    public Comic getComicbytitle(@Param("title") String title);


    public List<Comic> findall();

    public void AddComic(Comic comic);

    public void UpdateComic (Comic comic);

    public void DeletebyID(@Param("id") int id);

    public List<Comic> findbyCategory(@Param("cid") int cid);
}
