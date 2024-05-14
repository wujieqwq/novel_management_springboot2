package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.Chapter;
import com.wujie.project.pojo.ChapterReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

    @Select("select count(cid) from chapter where bid = #{bid}")
    Integer countChapter(Integer bid);

    @Select("select cid,chapter_number from chapter where bid = #{bid}")
    List<Chapter> selectAllChapterNumber(Integer bid);
}
