package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @date 2020/2/14 - 20:41
 */
public class Menu {
    int id;
    String path;
    String name;
    String nameZh;
    String iconCls;
    String component;
    int parentId;
    List<Menu> children;

    public Menu(int id, String path, String name, String nameZh, String iconCls, String component, int parentId, List<Menu> children) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.nameZh = nameZh;
        this.iconCls = iconCls;
        this.component = component;
        this.parentId = parentId;
        this.children = children;
    }

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", component='" + component + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}
