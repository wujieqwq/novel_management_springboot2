package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.FeedBack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedBackMapper extends BaseMapper<FeedBack> {
    List<FeedBack> selectAllfb(String searchText,Integer uid);

    List<FeedBack> selectFBByUid(Integer uid);
}
