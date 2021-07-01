package com.shark.App.exeption;
//401
public class ErrorUnauthorized extends RuntimeException{
    public ErrorUnauthorized(String msg) {
        super(msg);
    }
}
