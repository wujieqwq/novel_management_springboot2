package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.ViolationRecord;

public interface ViolationRecordService {
    int deleteRecord(String vrid);

    int insertVRecord(ViolationRecord vr, String uid);


    PageInfo<ViolationRecord> selectAllVRecord(Integer pageNum, Integer pageSize);
}
