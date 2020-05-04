package com.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dao.UserMapper;
import com.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 * @date 2020/2/6 - 12:14
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    //private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public User get(String username, String password){
        //Map<String,Object> map = new HashMap<String,Object>();
        return userMapper.getbynameandpassword(username,password);
    }

    @Cacheable
    public User findUserById(int id){
        //System.out.println("未进入缓存");
        return userMapper.findUserbyId(id);
    }

    public User getbyname(String name){
        return userMapper.getbyname(name);
    }

    public int register(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        String cover = user.getCover();

        user.setUsername(username);
        user.setEmail(email);
        user.setCover(cover);

        if (username.equals("") || password.equals("")) {
            return 0;
        }
        boolean exist = isExist(username);
        if (exist) {
            return 2;
        }
        userMapper.save(user);
        return 1;
    }

    boolean isExist(String username){
        User user = userMapper.getbyname(username);
        return user!=null;
    }

}
