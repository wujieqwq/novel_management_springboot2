package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Adaptation {
    @TableId(value = "aid",type = IdType.AUTO)
    private Integer aid;
    private String studio;
    private String scope;
    private Integer licenseMoney;
    private Integer adaptationType;
    private Integer adaptationStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date adaptationDate;
    private Integer adaptationDuration;
    private String remark;
    private Integer bid;
    @TableField(exist = false)
    private Book book;
}
