package com.Controller;

import com.dao.RoleMenuMapper;
import com.pojo.Menu;
import com.pojo.RoleMenu;
import com.pojo.User;
import com.result.Result;
import com.result.ResultFactory;
import com.service.MenuService;
import com.service.TokenService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date 2020/2/14 - 22:12
 */
@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    TokenService tokenService;

    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    @GetMapping("/api/menu")
    public List<Menu> menu(HttpServletRequest httpServletRequest){
        User user = tokenService.getUser(httpServletRequest);
        List<Menu> menus = menuService.getMenubyname(user.getUsername());
        for(Menu menu :menus){
            menu.setChildren(menuService.getallbyParentId(menu.getId()));
        }
        Iterator<Menu> iterator = menus.iterator();
        while (iterator!=null && iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
        return menus;
    }


    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }

    @GetMapping("/api/admin/role/menu")
    public Result listAllMenus() {
        User user = userService.getbyname("admin");
        List<Menu> menus = menuService.getMenubyname(user.getUsername());
        for(Menu menu :menus){
            menu.setChildren(menuService.getallbyParentId(menu.getId()));
        }
        Iterator<Menu> iterator = menus.iterator();
        while (iterator!=null && iterator.hasNext()) {
            Menu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
        return ResultFactory.buildSuccessResult(menus);
    }
}
