package com.Controller;

import com.pojo.Menu;
import com.pojo.User;
import com.service.MenuService;
import com.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    @GetMapping("/api/menu")
    public List<Menu> menu(HttpServletRequest httpServletRequest){
        User user = tokenService.getUser(httpServletRequest);
        List<Menu> menus = menuService.getMenubyname(user.getUsername());
        for(Menu menu :menus){
            menu.setChildren(menuService.getallbyParentId(menu.getId()));
        }
        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            //System.out.println(menu.getId()+" "+menu.getParentId());
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

}
