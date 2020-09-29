package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @date 2020/2/5 - 21:24
 */

@Mapper
public interface UserMapper {
    public User findUserbyId(@Param("id") int id);

    public List<User> findall();

    public User getbynameandpassword(String username, String password);

    public User getbyname(String username);

    public void save(User user);

    public void update(User user);

    public void delete(@Param("id") int id);
}
