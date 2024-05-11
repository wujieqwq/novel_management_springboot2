package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.SignMapper;
import com.wujie.project.pojo.Sign;
import com.wujie.project.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService{
    @Autowired
    private SignMapper signMapper;
    @Override
    public void insertSignApply(Sign sign) {
        signMapper.insert(sign);
    }

    @Override
    public PageInfo<Sign> selectSignByBid(Integer pageNum, Integer pageSize, String bid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sign> res = signMapper.selectSignByBid(bid);
        return new PageInfo<>(res);
    }
}
