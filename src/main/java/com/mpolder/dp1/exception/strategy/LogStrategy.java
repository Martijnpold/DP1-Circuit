package com.mpolder.dp1.exception.strategy;

public class LogStrategy implements IExceptionStrategy {
    @Override
    public void execute(Exception e) {
        System.out.println("Could not construct a valid circuit using the given parameters");
        System.out.println("Reason: " + e.getMessage());
    }
}
