package com.myxq.community.model;

import lombok.Data;

/**
 * @author 李永庆
 * @since 2019/11/21
 */
@Data
public class Question {

    private Integer id;

    private String title;

    private String description;

    private String tag;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer creator;

    private Integer viewCount;

    private Integer commentCount;

    private Integer likeCount;
}
