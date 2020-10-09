package com.kozachenko.lesson14;

public class UnsimilarDigitException extends RuntimeException {
    public UnsimilarDigitException(String message) {
        super(message);
    }

    public UnsimilarDigitException(String message, Throwable cause) {
        super(message, cause);
    }
}
