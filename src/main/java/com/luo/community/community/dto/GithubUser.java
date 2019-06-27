package com.luo.community.community.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:罗云继
 * @date 2019/6/24 22:39
 */
@Data
public class GithubUser implements Serializable {
    private String id;
    private String login;
    private String bio;
    private String avatar_url;


}
