package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Post {
    @TableId(value = "pid",type = IdType.AUTO)
    private Integer pid;
    private String postContent;
    private String pname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDate;
    private Integer topStatus;//0不置顶,1置顶
    private Integer uid;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private Book book;
}
