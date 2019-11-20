package com.myxq.community.mapper;


import com.myxq.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 李永庆
 * @since 2019/11/19
 */
@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name}, #{accountId}, #{token},#{getCreate},#{getModified})")
    public void insert( User user);
}
