package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.pojo.ChapterReview;

import java.util.List;

public interface ReviewService {
    PageInfo<BookReview> selectBookReviewWithTagByBid(Integer pageNum, Integer pageSize, Integer bid,String type);

    int updateCustomTag(Integer brid, String tagStatus);

    PageInfo<ChapterReview> selectChapterReview(Integer pageNum, Integer pageSize, Integer bid, Integer cid);

    Integer deleteChapterReview(Integer crid);

    Integer deleteBookReview(Integer brid);

    PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, Integer bid);
}
