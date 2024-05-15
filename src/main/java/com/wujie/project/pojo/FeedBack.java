package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FeedBack {
    @TableId(value = "fid",type = IdType.AUTO)
    private Integer fid;
    private String feedbackContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feedbackDate;
    private Integer uid;
    @TableField(exist = false)
    private User user;
}
