package com.service;

import com.dao.CommentMapper;
import com.pojo.Comment;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @date 2020/8/7 - 19:27
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserService userService;



    public List<Comment> getCommentByArticleId(int articleId){
        List<Comment> commentList = commentMapper.getByArticleId(articleId);
        int n = commentList.size();
        int [] father = new int [n+10];

        List<Comment> comments = new ArrayList<>();
        for(Comment comment : commentList){
            father[comment.getId()] = comment.getPid();
            if(comment.getId().equals(comment.getPid())){
                comment = getTrueComment(comment);
                comments.add(comment);
            }
        }
        HashMap<Integer,ArrayList<Comment>> vis = new HashMap<>();
        for(Comment comment : commentList){
            if(comment.getId().equals(comment.getPid())){
                continue;
            }
            comment = getTrueComment(comment);
            if(!vis.containsKey(father[comment.getId()])){
                ArrayList<Comment> tmp = new ArrayList<>();
                tmp.add(comment);
                vis.put(father[comment.getId()],tmp);
            }
            else{
                ArrayList<Comment>tmp = vis.get(father[comment.getId()]);
                tmp.add(comment);
                vis.put(father[comment.getId()],tmp);
            }
        }
        Iterator it = vis.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            for(Comment comment : comments){
                if(e.getKey().equals(comment.getId())){
                    comment.setReply((ArrayList<Comment>)e.getValue());
                }
            }

        }

        return comments;
    }

    public void addComment(Comment comment){
        //System.out.println(comment.toString());
        Date date = new Date();
        comment.setCreateTime(date);
        if(comment.getPid() == null){
            int pid = commentMapper.findLastId() + 1;
            comment.setPid(pid);
        }
        commentMapper.add(comment);

    }

    public Comment getTrueComment(Comment comments){

        User fromUser = userService.findUserById(comments.getFromId());
        User toUser = userService.findUserById(comments.getToId() == null ? comments.getFromId() : comments.getToId());
        comments.setFromName(fromUser.getUsername());
        comments.setToName(toUser.getUsername());
        comments.setFromCover(fromUser.getCover());
        comments.setToCover(toUser.getCover());
        comments.setReply(new ArrayList<Comment>());
        return comments;
    }
}

