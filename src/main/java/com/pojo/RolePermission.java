package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2020/7/13 - 16:53
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermission {
    int id;
    int pid;
    int rid;
}
