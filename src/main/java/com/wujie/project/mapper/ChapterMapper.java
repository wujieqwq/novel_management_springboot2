package com.wujie.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChapterMapper {

    @Select("select count(cid) from chapter where bid = #{bid}")
    Integer countChapter(String bid);
}
