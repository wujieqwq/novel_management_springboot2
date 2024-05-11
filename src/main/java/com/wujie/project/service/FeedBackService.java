package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.FeedBack;

import java.util.List;

public interface FeedBackService {
    PageInfo<FeedBack> selectAllfb(Integer pageNum, Integer pageSize);

    void insertFB(FeedBack feedBack);
}
