package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Chapter {
    @TableId(value = "cid",type = IdType.AUTO)
    private Integer cid;
    private String cname;
    private String chapterContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date chapterDate;
    private String auditStatus;
    private String auditRemarks;
    private Integer bid;
    @TableField(exist = false)
    private Book book;
}
