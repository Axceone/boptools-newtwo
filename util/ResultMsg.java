package com.baiwang.bophttpapi.util;

import java.io.Serializable;

public class ResultMsg implements Serializable {

    //响应业务状态
    private Integer status;
    //响应消息
    private String msg;
    //响应中的数据
    private Object data;

    public static ResultMsg build(Integer status,String msg,Object data){
        return new ResultMsg(status,msg,data);
    }

    public static ResultMsg ok(Object data){
        return new ResultMsg(data);
    }

    public static ResultMsg ok(){
        return new ResultMsg(null);
    }

    public ResultMsg(){
    }

    public ResultMsg(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultMsg(Object data) {
        this.status = 200;
        this.data = data;
        this.msg = "OK";
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
