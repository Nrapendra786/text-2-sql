package com.techwaala;

public class InvalidQueryException extends RuntimeException {
    public InvalidQueryException(String message){
        super(message);
    }
}
