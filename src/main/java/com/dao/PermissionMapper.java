package com.dao;

import com.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/7/13 - 16:44
 */
@Mapper
public interface PermissionMapper {
      public Permission getPermissionbyid(@Param("id") int id);


      public List<Permission>all();


}
