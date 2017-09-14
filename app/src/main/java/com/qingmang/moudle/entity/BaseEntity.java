package com.qingmang.moudle.entity;

import java.io.Serializable;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class BaseEntity<T> implements Serializable{

    //"code":"1","msg":"OK","data":"null"
    private String code;
    private String msg;
    private T t;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
