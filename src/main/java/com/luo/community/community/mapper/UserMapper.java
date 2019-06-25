package com.luo.community.community.mapper;

import com.luo.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther:罗云继
 * @date 2019/6/25 18:30
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user values(null,#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
