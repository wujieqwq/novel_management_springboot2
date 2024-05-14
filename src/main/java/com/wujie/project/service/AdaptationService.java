package com.wujie.project.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Adaptation;
import com.wujie.project.pojo.Book;

import java.util.List;

public interface AdaptationService{


    PageInfo<Adaptation> selectAdaptationByBid(Integer PageNum,Integer PageSize,Integer bid,Integer status);

    Integer insertAdApply(Adaptation adaptation);

    List<Book> selectPerAdBook();
}
