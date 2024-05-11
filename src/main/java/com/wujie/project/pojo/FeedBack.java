package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FeedBack {
    @TableId
    private String fid;
    private String feedbackContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feedbackDate;
    @TableField(exist = false)
    private User user;
}
