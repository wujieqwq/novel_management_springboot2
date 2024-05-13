package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Sign;

public interface SignService {
    void insertSignApply(Sign sign);

    PageInfo<Sign> selectSign(Integer pageNum, Integer pageSize, Integer bid,Integer status);
}
