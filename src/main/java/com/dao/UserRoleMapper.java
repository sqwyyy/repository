package com.dao;

import com.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/2/14 - 21:19
 */
@Mapper
public interface UserRoleMapper {
    public List<UserRole>listbyuid(@Param("uid")int uid);

    public void insert(UserRole userRole);
}
