package com.myxq.community.model;


import lombok.Data;

/**
 * @author 李永庆
 * @since 2019/11/19
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String accountId;

    private String token;

    private Long getCreate;

    private Long getModified;

    private String bio;

    private String avatarUrl;

}
