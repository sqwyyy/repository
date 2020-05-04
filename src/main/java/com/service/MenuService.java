package com.service;

import com.dao.MenuMapper;
import com.pojo.Menu;
import com.pojo.RoleMenu;
import com.pojo.User;
import com.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/2/14 - 21:38
 */
@Service
public class MenuService {

    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleMenuService roleMenuService;
    @Autowired
    MenuMapper menuMapper;

    public List<Menu>getMenubyname(String username){
        User user = userService.getbyname(username);
        List<UserRole> userRoleList = userRoleService.listbyuid(user.getId());
        List<Menu>menus = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            List<RoleMenu> roleMenuList = roleMenuService.findAllByRid(userRole.getRid());
            for (RoleMenu roleMenu : roleMenuList) {
                menus.add(menuMapper.findbyId(roleMenu.getMid()));
            }
        }
        return menus;
    }

    public List<Menu> getallbyParentId(int id){
        return menuMapper.findbyParentid(id);
    }
}
