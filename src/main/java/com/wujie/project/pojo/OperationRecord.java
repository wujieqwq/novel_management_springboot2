package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OperationRecord {
    @TableId(value = "orid",type = IdType.AUTO)
    private Integer orid;
    private String orContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orDate;
    private Integer uid;
    private Integer pid;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Post post;
}
