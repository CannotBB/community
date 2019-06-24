package com.luo.community.community.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther:罗云继
 * @date 2019/6/24 22:12
 */
@Data
public class AccessTokenDTO implements Serializable {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
