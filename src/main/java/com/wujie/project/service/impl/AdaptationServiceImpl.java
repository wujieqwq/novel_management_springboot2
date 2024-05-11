package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.AdaptationMapper;
import com.wujie.project.pojo.Adaptation;
import com.wujie.project.service.AdaptationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdaptationServiceImpl implements AdaptationService {
    @Autowired
    private AdaptationMapper adaptationMapper;

    @Override
    public int insertAdApply(Adaptation adaptation) {
        return adaptationMapper.insert(adaptation);
    }

    @Override
    public PageInfo<Adaptation> selectAdByBid(Integer pageNum, Integer pageSize, String bid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Adaptation> res = adaptationMapper.selectAdByBid(bid);
        return new PageInfo<>(res);
    }
}
