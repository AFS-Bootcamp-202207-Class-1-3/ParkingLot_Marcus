package com.parkinglot.exception;

public class WithoutAnyPositionException extends RuntimeException {
    @Override
    public String getMessage(){
        return "No available position.";
    }
}
