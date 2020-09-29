package com.service;

import com.dao.RolePermissionMapper;
import com.pojo.Permission;
import com.pojo.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/7/19 - 16:56
 */
@Service
public class RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    List<RolePermission> findAllByRid(int rid) {
        return rolePermissionMapper.findAllbyRid(rid);
    }

    public void savePermChanges(int rid, List<Permission> perms) {
        rolePermissionMapper.deletebyrid(rid);
        perms.forEach(p -> {
            RolePermission rp = new RolePermission();
            rp.setRid(rid);
            rp.setPid(p.getId());
            rolePermissionMapper.save(rp);
        });

    }
}
