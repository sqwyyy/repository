package com.pojo;

/**
 * @date 2020/2/14 - 20:46
 */
public class RoleMenu {
    int id;
    int rid;
    int mid;

    public RoleMenu() {
    }

    public RoleMenu(int id, int rid, int mid) {
        this.id = id;
        this.rid = rid;
        this.mid = mid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
