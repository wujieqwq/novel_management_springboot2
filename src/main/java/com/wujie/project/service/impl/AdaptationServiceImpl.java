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
    public Integer insertAdApply(Adaptation adaptation) {
        return adaptationMapper.insert(adaptation);
    }

    @Override
    public PageInfo<Adaptation> selectAdaptationByBid(Integer pageNum, Integer pageSize, Integer bid,String status) {
        PageHelper.startPage(pageNum,pageSize);
        List<Adaptation> res = adaptationMapper.selectAdaptationByBid(bid,status);
        return new PageInfo<>(res);
    }
}
