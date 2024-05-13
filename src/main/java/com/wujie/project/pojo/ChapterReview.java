package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ChapterReview {
    @TableId(value = "crid",type = IdType.AUTO)
    private Integer crid;
    private String crContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date crDate;
    @TableField(exist = false)
    private Chapter chapter;
    @TableField(exist = false)
    private User user;
}
