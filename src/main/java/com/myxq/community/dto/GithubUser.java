package com.myxq.community.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author 李永庆
 * @since 2019/11/19
        */
@Data
@ToString
public class GithubUser {

    private String name;

    private Long id;

    private String bio;

    private String avatarUrl;
}
