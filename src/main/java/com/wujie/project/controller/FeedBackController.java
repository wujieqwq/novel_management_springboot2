package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.FeedBack;
import com.wujie.project.service.FeedBackService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @RequestMapping("/selectAllfb")
    public ResultInfo selectAllfb(Integer pageNum,Integer pageSize){
        PageInfo<FeedBack> res = feedBackService.selectAllfb(pageNum,pageSize);
        return new ResultInfo(200,"查询成功",res);
    }


    @RequestMapping("/insertFB")
    public ResultInfo insertFB(FeedBack feedBack, HttpSession session){
        String uid = (String) session.getAttribute("uid");
        feedBackService.insertFB(feedBack);
        return new ResultInfo(200,"添加成功");
    }
}
