package com.wujie.project.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.ViolationRecord;
import com.wujie.project.service.ViolationRecordService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/vrecord")
@CrossOrigin
public class ViolationRecordController {
    @Autowired
    private ViolationRecordService violationRecordService;

    @RequestMapping("/selectAllVRecord")
    public ResultInfo selectAllVRecord(Integer pageNum,Integer pageSize){
        PageInfo<ViolationRecord> res = violationRecordService.selectAllVRecord(pageNum,pageSize);
        return new ResultInfo(200,"查询成功",res);
    }
    @RequestMapping("/insertVRecord")
    public ResultInfo insertVRecord(@RequestBody ViolationRecord vr, HttpServletRequest request){
        Integer uid = (Integer) request.getAttribute("uid");
        vr.setUid(uid);
        vr.setVrDate(DateUtil.date());
        violationRecordService.insertVRecord(vr);
        return new ResultInfo(200,"添加成功");
    }
    @RequestMapping(value = "/deleteVRecord")
    public ResultInfo deleteVRecord(Integer vrid){
        violationRecordService.deleteRecord(vrid);
        return new ResultInfo(200,"删除成功");
    }
}
