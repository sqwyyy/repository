package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @date 2020/2/14 - 20:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;
    private String name;
    private String nameZh;
    private boolean enabled;

    private List<Permission> perms;

    private  List<Menu> menus;



}
