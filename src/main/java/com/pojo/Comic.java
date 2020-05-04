package com.pojo;

/**
 * @date 2020/2/7 - 13:02
 */
public class Comic {
    private int id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private int cid;

    public Comic() {
    }

    public Comic(int id, String cover, String title, String author, String date, String press, String abs, int cid) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
