package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.ChapterReview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterReviewMapper extends BaseMapper<ChapterReview> {
    List<ChapterReview> selectChapterReview(Integer bid, Integer cid);
}
