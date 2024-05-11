package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OperationRecord {
    @TableId
    private String orid;
    private String orContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orDate;
    private String uid;
    private String pid;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Post post;
}
