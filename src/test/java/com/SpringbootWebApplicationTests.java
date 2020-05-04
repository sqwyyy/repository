package com;

import com.Controller.ComicController;
import com.pojo.Comic;
import com.pojo.Menu;
import com.service.ComicService;
import com.service.MenuService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class SpringbootWebApplicationTests {

    @Autowired
    MenuService menuService;

    @Autowired
    ComicController comicController;

    @Test
    void contextLoads() {
       // comicController.addcomic(new Comic("sad","sad"));
    }

    @Test
    public void test(){
        HashMap<Integer,String> map = new HashMap<>();
        map.get(3);
        StringBuffer s = new StringBuffer();
        
        ConcurrentHashMap<Integer,String> vis = new ConcurrentHashMap<>();
        AtomicIntegerArray arr = new AtomicIntegerArray(20);
        ConcurrentHashMap<Integer,String> brr = new ConcurrentHashMap<>();
        brr.put(1,"123");
        brr.get(1);
        int num = brr.size();

    }

}
