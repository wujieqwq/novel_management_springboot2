package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

    @Select("select count(cid) from chapter where bid = #{bid}")
    Integer countChapter(String bid);

    @Select("select audit_status from chapter where cid = #{cid};")
    Integer selectPreChapterStatus(String cid);
}
