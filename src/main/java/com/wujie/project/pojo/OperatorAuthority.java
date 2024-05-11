package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OperatorAuthority {
    @TableId
    private Integer oaid;
    private Integer authorityType;
    private String bid;
    private User user;
    private Book book;
    private Integer authorityAudit;
}
