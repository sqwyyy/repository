package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @date 2020/2/5 - 13:23
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    int id;
    private String username;
    private  String password;
    private String email;
    private String cover;

}
