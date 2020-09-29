package com.dao;

import com.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/7/13 - 16:54
 */
@Mapper
public interface RolePermissionMapper {
    public void deletebyrid(@Param("rid") int rid);

    List<RolePermission> findAllbyRid(int rid);

    public void save(RolePermission rolePermissions);
}
