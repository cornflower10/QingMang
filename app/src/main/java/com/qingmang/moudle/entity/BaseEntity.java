package com.qingmang.moudle.entity;

import java.io.Serializable;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class BaseEntity<T> implements Serializable{

    //"code":"1","msg":"OK","data":"null"
    private String status;
    private String detail;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
