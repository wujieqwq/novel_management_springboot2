package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Sign;

public interface SignService {
    void insertSignApply(Sign sign);

    PageInfo<Sign> selectSignByBid(Integer pageNum, Integer pageSize, String bid,String status);
}
