package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.Adaptation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdaptationMapper extends BaseMapper<Adaptation> {


    List<Adaptation> selectAdaptationByBid(Integer bid, String status);

}
