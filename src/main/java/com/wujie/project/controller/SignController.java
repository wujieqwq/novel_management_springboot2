package com.wujie.project.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Book;
import com.wujie.project.pojo.Sign;
import com.wujie.project.service.SignService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sign")
@CrossOrigin
public class SignController {
    @Autowired
    private SignService signService;

    @RequestMapping("/signApply")
    public ResultInfo signApply(@RequestBody Sign sign){
        sign.setSignDate(DateUtil.date());
        sign.setSignStatus(0);
        signService.insertSignApply(sign);
        return new ResultInfo(200,"新建成功");
    }
    @RequestMapping("/selectSign")
    public ResultInfo selectSign(Integer pageNum,Integer pageSize,Integer bid,Integer status){
        PageInfo<Sign> res = signService.selectSign(pageNum,pageSize,bid,status);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/selectNoSignBook")
    public ResultInfo selectNoSignBook(){
        List<Book> res = signService.selectNoSignBook();
        return new ResultInfo(200,"查询成功",res);
    }

}
