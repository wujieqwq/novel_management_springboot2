package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.OperatorAuthority;
import com.wujie.project.service.OperatorService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operator")
@CrossOrigin
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    /*
    搜索审核通过的运营员，其中包含管理作品与权限
     */
    @RequestMapping("/selectOp")
    public ResultInfo selectOp(String bid){
        List<OperatorAuthority> res = operatorService.selectOp(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    /*
    搜索审核员申请
     */
    @RequestMapping("/selectOpApply")
    public ResultInfo selectOpApply(String bid){
        List<OperatorAuthority> res = operatorService.selectOpApply(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/deleteOp")
    public ResultInfo deleteOp(String oaid){
        operatorService.deleteOp(oaid);
        return new ResultInfo(200,"删除成功");
    }

    @RequestMapping("/updateOp")
    public ResultInfo updateOp(OperatorAuthority op){
        operatorService.updateOp(op);
        return new ResultInfo(200,"更新成功");
    }
    /*
    查询操作记录
     */
    @RequestMapping("/selectRecord")
    public ResultInfo selectRecord(Integer pageNum,Integer pageSize){
        PageInfo<OperationRecord> res = operatorService.selectRecord(pageNum,pageSize);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/selectAuWithBook")
    public ResultInfo selectAuWithBook(){

        return new ResultInfo(200,"查询成功");
    }
}
