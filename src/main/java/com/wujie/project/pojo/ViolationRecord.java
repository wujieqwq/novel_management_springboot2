package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ViolationRecord {
    @TableId(value = "vrid",type = IdType.AUTO)
    private Integer vrid;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vrDate;
    private String violationResult;
    private Integer uid;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private User vuser;
}
