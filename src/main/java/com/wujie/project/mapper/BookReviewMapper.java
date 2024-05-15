package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.BookReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookReviewMapper extends BaseMapper<BookReview> {
    List<BookReview> selectBookReviewWithTagByBid(Integer bid,@Param("type") String type);

    List<BookReview> selectAllBookReviewWithTagByBid(Integer bid);

    List<BookReview> selectBookReviewByBid(Integer bid);
}
