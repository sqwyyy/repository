package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2020/7/13 - 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    int id;
    String name;
    String desk;
    String url;
}
