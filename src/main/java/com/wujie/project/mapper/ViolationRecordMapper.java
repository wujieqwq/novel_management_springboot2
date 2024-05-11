package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.ViolationRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViolationRecordMapper extends BaseMapper<ViolationRecord> {
    List<ViolationRecord> selectAllVRecord();
}
