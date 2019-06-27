package com.luo.community.community.model;

import lombok.Data;

/**
 * @auther:罗云继
 * @date 2019/6/26 21:35
 */
@Data
public class Question {
    private int id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModify;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
