package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {
    @TableId(value = "tid",type = IdType.AUTO)
    private Integer tid;
    private String tname;
}
