package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OperatorAuthority {
    @TableId(value = "oaid",type = IdType.AUTO)
    private Integer oaid;
    private Integer authorityType;
    private Integer bid;
    private User user;
    private Book book;
    private Integer authorityAudit;
}
