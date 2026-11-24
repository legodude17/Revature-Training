package com.banking.exception;

public class InvalidAccountException extends Exception {
    
    public InvalidAccountException() {
        super("Invalid account.");
    }

    public InvalidAccountException(String message) {
        super(message);
    }
}
