package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.BookReviewMapper;
import com.wujie.project.mapper.ChapterReviewMapper;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ChapterReviewMapper chapterReviewMapper;
    @Autowired
    private BookReviewMapper bookReviewMapper;


    @Override
    public PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, String bid) {
        PageHelper.startPage(pageNum,pageSize);
        List<BookReview> res = bookReviewMapper.selectBookReviewByBid(bid);
        return new PageInfo<>(res);
    }
}
