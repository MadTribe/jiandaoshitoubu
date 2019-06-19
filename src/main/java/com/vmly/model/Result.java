package com.vmly.model;



public class Result {

    private String msg;

    public String getCode() {
        return msg;
    }

    public void setCode(String code) {
        this.msg = msg;
    }

    public Result(String msg) {
        this.msg = msg;
    }


    public Result() {
    }

}
