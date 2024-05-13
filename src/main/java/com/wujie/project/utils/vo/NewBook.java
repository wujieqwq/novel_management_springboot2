package com.wujie.project.utils.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Stack;

@Data
public class NewBook {
    @TableId
    private Integer bid;
    private String bname;
    private String introduction;
    private String bookStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bookDate;
    private MultipartFile picture;
    private String uid;
}
