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
    public PageInfo<FeedBack> selectAllfb(Integer pageNum,Integer pageSize,String searchText,Integer uid) {
        PageHelper.startPage(pageNum,pageSize);
        List<FeedBack> feedBacks = feedBackMapper.selectAllfb(searchText,uid);
        PageInfo<FeedBack> feedBackPageInfo = new PageInfo<>(feedBacks);
        return feedBackPageInfo;
    }

    @Override
    public void insertFB(FeedBack feedBack) {
        feedBackMapper.insert(feedBack);
    }

    @Override
    public PageInfo<FeedBack> selectFBByUid(Integer pageNum, Integer pageSize, Integer uid) {
        PageHelper.startPage(pageNum,pageSize);
        List<FeedBack> res = feedBackMapper.selectFBByUid(uid);
        return new PageInfo<>(res);
    }

    @Override
    public Integer deleteFb(Integer fid) {
        return feedBackMapper.deleteById(fid);
    }
}
