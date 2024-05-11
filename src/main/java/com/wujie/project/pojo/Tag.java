package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {
    @TableId
    private String tid;
    private String tname;
}
