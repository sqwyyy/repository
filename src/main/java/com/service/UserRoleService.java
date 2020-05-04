package com.service;

import com.dao.UserRoleMapper;
import com.pojo.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/2/14 - 21:42
 */
@Service
public class UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    public List<UserRole> listbyuid(int uid){
        return userRoleMapper.listbyuid(uid);
    }
}
