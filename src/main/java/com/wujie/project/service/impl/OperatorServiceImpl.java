package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.OperatorMapper;
import com.wujie.project.pojo.Book;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.OperatorAuthority;
import com.wujie.project.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;
    @Override
    public List<OperatorAuthority> selectOp(Integer bid) {
        return operatorMapper.selectOp(bid);
    }

    @Override
    public List<OperatorAuthority> selectOpApply(Integer bid) {
        return operatorMapper.selectOpApply(bid);
    }

    @Override
    public int deleteOp(Integer oaid) {
        return operatorMapper.deleteById(oaid);
    }

    @Override
    public int updateOp(OperatorAuthority op) {
        op.setBid(op.getBook().getBid());
        return operatorMapper.updateById(op);
    }

    @Override
    public PageInfo<OperationRecord> selectRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OperationRecord> res = operatorMapper.selectRecord();
        return new PageInfo<>(res);
    }

    @Override
    public List<Book> selectPerBid(Integer uid) {
        return operatorMapper.selectPerBid(uid);
    }
}
