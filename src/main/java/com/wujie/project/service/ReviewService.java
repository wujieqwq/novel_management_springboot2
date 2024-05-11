package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;

import java.util.List;

public interface ReviewService {
    PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, String bid);
}
