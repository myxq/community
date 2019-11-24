package com.myxq.community.dto;

import com.myxq.community.model.User;
import lombok.Data;

/**
 * @author 李永庆
 * @since 2019/11/22
 */
@Data
public class QuestionDTO {

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

    private User user;
}
