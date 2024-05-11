package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where email = #{email};")
    User selectByEmail(String email);

    @Update("update user set password = #{password} where email = #{email}")
    void updatePassWordByEmail(String email, String password);

    @Select("select uid from user where uname = #{uname}")
    String selectUidByUname(String uname);

    @Select("select uid from user where email = #{email}")
    String selectUidByEmail(String email);
}
