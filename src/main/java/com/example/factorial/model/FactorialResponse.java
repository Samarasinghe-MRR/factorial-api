package com.example.factorial.model;

public class FactorialResponse {
    private int number;
    private long factorial;
    private String error;

    public FactorialResponse(int number, long factorial) {
        this.number = number;
        this.factorial = factorial;
    }

    public FactorialResponse(String error) {
        this.error = error;
    }

    public int getNumber() {
        return number;
    }

    public long getFactorial() {
        return factorial;
    }

    public String getError() {
        return error;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFactorial(long factorial) {
        this.factorial = factorial;
    }

    public void setError(String error) {
        this.error = error;
    }
}
