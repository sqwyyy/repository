package com.dao;

import com.pojo.RoleMenu;
import com.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/2/14 - 21:20
 */
@Mapper
public interface RoleMenuMapper {
    public List<RoleMenu> findbyRid(@Param("rid")int rid);

    public void saveall(RoleMenu roleMenu);

    public void deletebyid(@Param("rid") int rid);
}
