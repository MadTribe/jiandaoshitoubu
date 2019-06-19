package com.vmly.model;

public class JudgeResult {

    private String username;

    private Result result;

    public enum Result {
        LOSE,
        SUCCESS
    }


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JudgeResult(String username, Result result) {
        this.username = username;
        this.result = result;
    }

    public JudgeResult() {
    }
}
