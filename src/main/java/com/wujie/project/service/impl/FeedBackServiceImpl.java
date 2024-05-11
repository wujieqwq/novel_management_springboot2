package com.wujie.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.FeedBackMapper;
import com.wujie.project.pojo.FeedBack;
import com.wujie.project.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;
    @Override
    public PageInfo<FeedBack> selectAllfb(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FeedBack> feedBacks = feedBackMapper.selectAllfb();
        PageInfo<FeedBack> feedBackPageInfo = new PageInfo<>(feedBacks);
        return feedBackPageInfo;
    }

    @Override
    public void insertFB(FeedBack feedBack) {
        feedBackMapper.insert(feedBack);
    }
}
