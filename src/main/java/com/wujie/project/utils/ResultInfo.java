package com.wujie.project.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {
    private Integer code;

    private String msg;

    private Object data;
    private String token;

    public ResultInfo(Integer code,String msg){
        this.code =code;
        this.msg =msg;
    }

    public ResultInfo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
