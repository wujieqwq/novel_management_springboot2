package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.OperatorAuthority;

import java.util.List;

public interface OperatorService {
    List<OperatorAuthority> selectOp(String bid);

    List<OperatorAuthority> selectOpApply(String bid);

    int deleteOp(String oaid);

    int updateOp(OperatorAuthority op);

    PageInfo<OperationRecord> selectRecord(Integer pageNum, Integer pageSize);
}
