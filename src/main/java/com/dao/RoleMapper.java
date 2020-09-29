package com.dao;

import com.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/7/14 - 19:58
 */
@Mapper
public interface RoleMapper {
    public Role findbyId(@Param("id") int id);

    public List<Role>findall();

    public void updateRole(Role role);

    public void add(Role role);
}
