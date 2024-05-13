package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;

public interface ReviewService {
    PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, Integer bid,String type);

    int updateCustomTag(Integer brid, String tagStatus);
}
