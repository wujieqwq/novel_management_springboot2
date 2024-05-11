package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Book {
    @TableId
    private String bid;
    private String bname;
    private String introduction;
    private String bookStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bookDate;
    private String picture;
    private String uid;
    @TableField(exist = false)
    private User user;
}
