package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.BookReviewMapper;
import com.wujie.project.mapper.ChapterReviewMapper;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.pojo.ChapterReview;
import com.wujie.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ChapterReviewMapper chapterReviewMapper;
    @Autowired
    private BookReviewMapper bookReviewMapper;


    @Override
    public PageInfo<BookReview> selectBookReviewWithTagByBid(Integer pageNum, Integer pageSize, Integer bid,String type) {
        PageHelper.startPage(pageNum,pageSize);
        List<BookReview> res = new ArrayList<>();
        if ("-1".equals(type)){
            res = bookReviewMapper.selectAllBookReviewWithTagByBid(bid);
        }else{
            res = bookReviewMapper.selectBookReviewWithTagByBid(bid,type);
        }
        return new PageInfo<>(res);
    }

    @Override
    public int updateCustomTag(Integer brid, String tagStatus) {
        BookReview bookReview = new BookReview();
        bookReview.setBrid(brid);
        bookReview.setTagStatus(tagStatus);
        return bookReviewMapper.updateById(bookReview);
    }

    @Override
    public PageInfo<ChapterReview> selectChapterReview(Integer pageNum, Integer pageSize, Integer bid, Integer cid) {
        PageHelper.startPage(pageNum,pageSize);
        List<ChapterReview> res = chapterReviewMapper.selectChapterReview(bid,cid);
        return new PageInfo<>(res);
    }

    @Override
    public Integer deleteChapterReview(Integer crid) {
        return chapterReviewMapper.deleteById(crid);
    }

    @Override
    public Integer deleteBookReview(Integer brid) {
        return bookReviewMapper.deleteById(brid);
    }

    @Override
    public PageInfo<BookReview> selectBookReviewByBid(Integer pageNum, Integer pageSize, Integer bid) {
        PageHelper.startPage(pageNum,pageSize);
        List<BookReview> res = bookReviewMapper.selectBookReviewByBid(bid);
        return new PageInfo<>(res);
    }

}
