package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Book;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.OperatorAuthority;

import java.util.List;

public interface OperatorService {
    List<OperatorAuthority> selectOp(Integer bid);

    List<OperatorAuthority> selectOpApply(Integer bid);

    int deleteOp(Integer oaid);

    int updateOp(OperatorAuthority op);

    PageInfo<OperationRecord> selectRecord(Integer pageNum, Integer pageSize);

    List<Book> selectPerBid(Integer uid);
}
