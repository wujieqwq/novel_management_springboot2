package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;

public interface ReviewService {
    PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, String bid,String type);

    int updateCustomTag(String brid, String tagStatus);
}
