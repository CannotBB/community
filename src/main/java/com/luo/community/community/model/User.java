package com.luo.community.community.model;

import lombok.Data;

/**
 * @auther:罗云继
 * @date 2019/6/25 18:33
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
