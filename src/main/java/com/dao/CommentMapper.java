package com.dao;

import com.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/8/7 - 22:54
 */

@Mapper
public interface CommentMapper {
    public List<Comment> getByArticleId(@Param("articleId") int articleId);

    public void add(Comment comment);

    public int findLastId();

}
