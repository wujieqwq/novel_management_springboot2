package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.OperatorAuthority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperatorMapper extends BaseMapper<OperatorAuthority> {
    List<OperatorAuthority> selectOp(Integer bid);

    List<OperatorAuthority> selectOpApply(Integer bid);

    List<OperationRecord> selectRecord();
}
