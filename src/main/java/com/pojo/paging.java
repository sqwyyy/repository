package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @date 2020/4/20 - 13:11
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class paging {
    List<Article>content;
    Long totalElements;
}
