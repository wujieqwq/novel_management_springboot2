package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Sign {
    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;
    private String signContent;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date signDate;
    private Integer signStatus;
    private Integer signType;
    private Integer signDuration;
    private Integer bid;
    @TableField(exist = false)
    private Book book;
}
