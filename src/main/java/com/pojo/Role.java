package com.pojo;

/**
 * @date 2020/2/14 - 20:37
 */
public class Role {
    private int id;
    private String name;
    private String name_zh;

    public Role() {
    }

    public Role(int id, String name, String name_zh) {
        this.id = id;
        this.name = name;
        this.name_zh = name_zh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }
}
