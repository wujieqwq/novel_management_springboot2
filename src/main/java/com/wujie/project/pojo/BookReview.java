package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookReview {
    @TableId
    private String brid;
    private String brContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date brDate;
    private String customTag;
    private String tagStatus;
    private String uid;
    private String bid;
    @TableField(exist = false)
    private Book book;
    @TableField(exist = false)
    private User user;
}
