package com.it.lawhelp.spring.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Result {
    private Integer code;
    private Boolean isSuccess;
    private String massage;
    private Object result;
    public Result(){
        super();
    }
    public Result(Boolean success,Integer code,String massage){
        super();
        this.isSuccess = success;
        this.code = code;
        this.massage = massage;
    }
    public Result(Boolean success,Integer code,Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.result=result;
    }
    public Result(Boolean success,Integer code,String massage,Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.massage=massage;
        this.result=result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
