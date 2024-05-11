package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Adaptation;

public interface AdaptationService {
    int insertAdApply(Adaptation adaptation);

    PageInfo<Adaptation> selectAdByBid(Integer pageNum, Integer pageSize, String bid);
}
