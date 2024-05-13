package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.ViolationRecord;
import com.wujie.project.service.ViolationRecordService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultInfo insertVRecord(ViolationRecord vr, HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        violationRecordService.insertVRecord(vr,uid);
        return new ResultInfo(200,"添加成功");
    }
    @RequestMapping(value = "/{vrid}",method = RequestMethod.DELETE)
    public ResultInfo deleteVRecord(@PathVariable Integer vrid){
        violationRecordService.deleteRecord(vrid);
        return new ResultInfo(200,"删除成功");
    }
}
