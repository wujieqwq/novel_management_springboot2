package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Adaptation {
    @TableId
    private String aid;
    private String studio;
    private String scope;
    private Integer licenseMoney;
    private String adaptationType;
    private Integer adaptationStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date adaptationDate;
    private Integer adaptationDuration;
    private String remark;
    private String bid;
    @TableField(exist = false)
    private Book book;
}
