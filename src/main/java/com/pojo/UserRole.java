package com.pojo;

/**
 * @date 2020/2/14 - 20:40
 */
public class UserRole {
    int id;
    int uid;
    int rid;

    public UserRole(int id, int uid, int rid) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
    }

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
