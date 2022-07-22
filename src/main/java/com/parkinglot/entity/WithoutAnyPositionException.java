package com.parkinglot.entity;

public class WithoutAnyPositionException extends RuntimeException {
    @Override
    public String getMessage(){
        return "No available position.";
    }
}
