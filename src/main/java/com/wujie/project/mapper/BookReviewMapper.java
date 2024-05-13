package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.BookReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookReviewMapper extends BaseMapper<BookReview> {
    List<BookReview> selectBookReviewByBid(Integer bid,@Param("type") String type);

    List<BookReview> selectAllBookReviewByBid(Integer bid);
}
