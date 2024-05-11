package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Chapter {
    @TableId
    private String cid;
    private String cname;
    private String chapterContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date chapterDate;
    private Integer auditStatus;
    private String auditRemarks;
    @TableField(exist = false)
    private Book book;
}
