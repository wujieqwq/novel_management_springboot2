package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Adaptation;
import com.wujie.project.service.AdaptationService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adaptation")
@CrossOrigin
public class AdaptationController {

    @Autowired
    private AdaptationService adaptationService;

    @RequestMapping("/insertAdApply")
    public ResultInfo insertAdApply(Adaptation adaptation){
        adaptationService.insertAdApply(adaptation);
        return new ResultInfo(200,"申请成功");
    }

    @RequestMapping("/selectAd")
    public ResultInfo selectAdByBid(Integer pageNum,Integer pageSize,String bid,String status){
        PageInfo<Adaptation> res = adaptationService.selectAdaptationByBid(pageNum,pageSize,bid,status);
        return new ResultInfo(200,"查询成功",res);
    }
}
