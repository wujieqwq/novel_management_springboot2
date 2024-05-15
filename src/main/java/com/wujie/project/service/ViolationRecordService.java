package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.ViolationRecord;

public interface ViolationRecordService {
    int deleteRecord(Integer vrid);

    int insertVRecord(ViolationRecord vr);


    PageInfo<ViolationRecord> selectAllVRecord(Integer pageNum, Integer pageSize);
}
