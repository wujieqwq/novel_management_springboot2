package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.service.ReviewService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/selectBookReviewByBid")
    public ResultInfo selectBookReviewByBid(Integer pageNum,Integer pageSize,Integer bid,String type){
        PageInfo<BookReview> res = reviewService.selectBookReviewByBid(pageNum,pageSize,bid,type);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/updateCustomTag")
    public ResultInfo updateCustomTag(Integer brid,String tagStatus){
        reviewService.updateCustomTag(brid,tagStatus);
        return new ResultInfo(200,"修改成功");
    }
}
