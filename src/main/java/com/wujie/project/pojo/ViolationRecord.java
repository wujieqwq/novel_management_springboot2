package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ViolationRecord {
    @TableId
    private String vrid;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vrDate;
    private String violationResult;
    private String uid;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private User vuser;
}
