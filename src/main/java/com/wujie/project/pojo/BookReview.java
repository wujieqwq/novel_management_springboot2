package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookReview {
    @TableId(value = "brid",type = IdType.AUTO)
    private Integer brid;
    private String brContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date brDate;
    private String customTag;
    private String tagStatus;
    private Integer uid;
    private Integer bid;
    @TableField(exist = false)
    private Book book;
    @TableField(exist = false)
    private User user;
}
