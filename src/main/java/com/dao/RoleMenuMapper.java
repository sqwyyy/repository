package com.dao;

import com.pojo.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/2/14 - 21:20
 */
@Mapper
public interface RoleMenuMapper {
    public List<RoleMenu>lsitbyrid(@Param("rid")int rid);

}
