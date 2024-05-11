package com.wujie.project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId
    private String uid;
    private String uname;
    private String email;
    private String password;
    private String userType;
    private String gender;
    private String signature;
}
