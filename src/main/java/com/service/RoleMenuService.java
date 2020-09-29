package com.service;

import com.dao.RoleMenuMapper;
import com.pojo.RoleMenu;
import com.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @date 2020/2/14 - 21:54
 */
@Service
public class RoleMenuService {
    @Autowired
    RoleMenuMapper roleMenuMapper;

    public List<RoleMenu> findAllByRid(int rid){
        return roleMenuMapper.findbyRid(rid);
    }

    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        roleMenuMapper.deletebyid(rid);
        List<RoleMenu> rms = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            RoleMenu rm = new RoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            roleMenuMapper.saveall(rm);
        }
    }
}
