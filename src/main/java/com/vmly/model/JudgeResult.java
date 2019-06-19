package com.vmly.model;

public class JudgeResult {

    private String name;

    private Result result;

    public enum Result {
        LOSE,
        WIN
    }


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JudgeResult(String name, Result result) {
        this.name = name;
        this.result = result;
    }

    public JudgeResult() {
    }
}
