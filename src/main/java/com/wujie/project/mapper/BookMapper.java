package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Select("select * from book where uid = #{uid} order by bid desc")
    List<Book> selectByUid(Integer uid);

    @Select("select * from book where bid = #{bid}")
    Book selectByBid(Integer bid);
}
