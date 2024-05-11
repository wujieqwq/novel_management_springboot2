package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.BookReview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookReviewMapper extends BaseMapper<BookReview> {
    List<BookReview> selectBookReviewByBid(String bid);
}
