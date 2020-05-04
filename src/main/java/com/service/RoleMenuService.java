package com.service;

import com.dao.RoleMenuMapper;
import com.pojo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/2/14 - 21:54
 */
@Service
public class RoleMenuService {
    @Autowired
    RoleMenuMapper roleMenuMapper;

    public List<RoleMenu>findAllByRid(int rid){
        return roleMenuMapper.lsitbyrid(rid);
    }
}
