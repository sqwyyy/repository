package com.service;

import com.dao.RoleMapper;
import com.dao.RoleMenuMapper;
import com.dao.RolePermissionMapper;
import com.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/7/14 - 20:05
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleMenuMapper roleMenuMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Autowired
    RolePermissionService rolePermissionService;

    public List<Role> listall(){
        return roleMapper.findall();
    }

    public List<Role> listWithPermsAndMenus() {
        List<Role> roles = listall();
        List<Permission> perms = new ArrayList<>();
        List<Menu> menus = new ArrayList<>();;
        for (Role role : roles) {
            List<RolePermission> rolePermissions = rolePermissionMapper.findAllbyRid(role.getId());
            for(RolePermission rolePermission : rolePermissions){
                perms.add(permissionService.getPermissionById(rolePermission.getPid()));
            }
            List<RoleMenu>roleMenus = roleMenuMapper.findbyRid(role.getId());
            for(RoleMenu roleMenu :roleMenus){
                menus.add(menuService.getlistMenusById(roleMenu.getMid()));
            }
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public void UpdateRole(Role role){
        roleMapper.updateRole(role);
    }

    public void UpdateRoleStatus(Role role){
        Role roleInb = roleMapper.findbyId(role.getId());
        roleMapper.updateRole(roleInb);
    }



    public void addorupdate(Role role){
        Role roledino = roleMapper.findbyId(role.getId());
        if(roledino == null){
            roleMapper.add(role);
        }
        else{
            roleMapper.updateRole(role);
        }
    }
}
