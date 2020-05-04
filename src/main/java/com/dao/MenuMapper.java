package com.dao;

import com.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/2/14 - 21:57
 */
@Mapper
public interface MenuMapper {
    public Menu findbyId(@Param("id")int id);

    public List<Menu> findbyParentid(@Param("parentId")int parentId);
}
