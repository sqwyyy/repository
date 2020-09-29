package com.Controller;

import com.pojo.Role;
import com.pojo.User;
import com.result.ResultFactory;
import com.service.TokenService;
import com.service.UserRoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.result.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * @date 2020/7/13 - 17:18
 */
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    TokenService tokenService;

    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    @GetMapping("api/admin/userid")
    public  Result getUser(HttpServletRequest request){
        return ResultFactory.buildSuccessResult(userService.findUserById(tokenService.getUser(request).getId()));
    }

    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody User user) {
        userService.UpdateUser(user);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(HttpServletRequest request) {
        userService.updateUserStatus(request);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    @PutMapping("/api/admin/user/password")
    public Result resetPassword(HttpServletRequest request) {
        userService.resetPassword(request);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }
}
