package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.FeedBack;

import java.util.List;

public interface FeedBackService {
    PageInfo<FeedBack> selectAllfb(Integer pageNum, Integer pageSize,String searchText,Integer uid);

    void insertFB(FeedBack feedBack);

    PageInfo<FeedBack> selectFBByUid(Integer pageNum, Integer pageSize, Integer uid);

    Integer deleteFb(Integer fid);
}
