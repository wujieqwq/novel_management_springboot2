package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Book;
import com.wujie.project.pojo.Sign;

import java.util.List;

public interface SignService {
    void insertSignApply(Sign sign);

    PageInfo<Sign> selectSign(Integer pageNum, Integer pageSize, Integer bid,Integer status);

    List<Book> selectNoSignBook();
}
