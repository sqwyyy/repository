package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @date 2020/8/5 - 22:13
 */

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    //评论主键id
    private Integer id;
    //评论的父id
    private Integer pid;
    //文章的id
    private Integer articleId;
    //评论者id
    private Integer fromId;
    //b被评论者id
    private Integer toId;
    //点赞的数量
    private Integer likeNum;
    //评论的内容
    private String content;
    //评论者姓名
    private String fromName;
    //被评论者姓名
    private String toName;
    //评论者头像
    private String fromCover;

    //被评论者头像
    private String toCover;

    private List<Comment>reply;
    //评论时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date createTime;
}
