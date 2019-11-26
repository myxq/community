package com.myxq.community.mapper;

import com.myxq.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李永庆
 * @since 2019/11/21
 */
@Mapper
@Component
public interface QuestionMapper {

    @Insert("insert into " +
            "question (id, title, description, gmt_create, gmt_modified, creator, tag)" +
            "values(#{id},#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();
}
