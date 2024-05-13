package com.wujie.project.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.ViolationRecordMapper;
import com.wujie.project.pojo.ViolationRecord;
import com.wujie.project.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {
    @Autowired
    private ViolationRecordMapper violationRecordMapper;
    @Override
    public int deleteRecord(Integer vrid) {
        return violationRecordMapper.deleteById(vrid);
    }

    @Override
    public int insertVRecord(ViolationRecord vr, Integer uid) {
        vr.setUid(uid);
        vr.setVrDate(DateUtil.date());
        return violationRecordMapper.insert(vr);
    }

    @Override
    public PageInfo<ViolationRecord> selectAllVRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ViolationRecord> res = violationRecordMapper.selectAllVRecord();
        return new PageInfo<>(res);
    }


}
