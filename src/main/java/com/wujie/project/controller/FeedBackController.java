package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.FeedBack;
import com.wujie.project.service.FeedBackService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/selectAllfb")//查当前作者的所有运营员的反馈
    public ResultInfo selectAllfb(Integer pageNum, Integer pageSize, String searchText,HttpServletRequest request){
        Integer uid = (Integer) request.getAttribute("uid");
        PageInfo<FeedBack> res = feedBackService.selectAllfb(pageNum,pageSize,searchText,uid);
        return new ResultInfo(200,"查询成功",res);
    }


    @RequestMapping("/insertFB")
    public ResultInfo insertFB(FeedBack feedBack, HttpServletRequest request){
        Integer uid = (Integer) request.getAttribute("uid");
        feedBack.setUid(uid);
        feedBackService.insertFB(feedBack);
        return new ResultInfo(200,"添加成功");
    }

    @RequestMapping("/selectFBByUid")//运营员查看自己的反馈
    public ResultInfo selectFBByUid(Integer pageNum,Integer pageSize,HttpServletRequest request){
        Integer uid = (Integer) request.getAttribute("uid");
        PageInfo<FeedBack> res = feedBackService.selectFBByUid(pageNum,pageSize,uid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/deleteFb")
    public ResultInfo deleteFb(Integer fid){
        feedBackService.deleteFb(fid);
        return new ResultInfo(200,"删除成功");
    }
}
