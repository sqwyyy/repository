package com.service;

import com.dao.PermissionMapper;
import com.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/7/13 - 17:04
 */
@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;


    public List<Permission> listall(){
        return permissionMapper.all();
    }

    public Permission getPermissionById(int id){
        return permissionMapper.getPermissionbyid(id);
    }
}
