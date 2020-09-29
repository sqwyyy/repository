package com.Controller;

import com.pojo.Comment;
import com.pojo.Role;
import com.result.Result;
import com.result.ResultFactory;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2020/8/7 - 19:09
 */

@CrossOrigin
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/api/comment/{articleId}")
    public Result getCommentByArticleId(@PathVariable("articleId") int articleId){
        return ResultFactory.buildSuccessResult(commentService.getCommentByArticleId(articleId));
    }


    @PutMapping("/api/comment/add")
    public Result addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResultFactory.buildSuccessResult("保存成功!");
    }

}
