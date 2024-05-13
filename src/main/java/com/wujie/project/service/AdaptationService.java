package com.wujie.project.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Adaptation;

public interface AdaptationService{


    PageInfo<Adaptation> selectAdaptationByBid(Integer PageNum,Integer PageSize,Integer bid,String status);

    Integer insertAdApply(Adaptation adaptation);
}
