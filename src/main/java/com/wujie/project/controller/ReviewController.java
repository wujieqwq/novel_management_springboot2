package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.service.ReviewService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/selectBookReviewByBid")
    public ResultInfo selectBookReviewByBid(Integer pageNum,Integer pageSize,String bid){
        PageInfo<BookReview> res = reviewService.selectBookReviewByBid(pageNum,pageSize,bid);
        return new ResultInfo(200,"查询成功",res);
    }

}