package com.mps.service;

public class StringServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public StringServiceException() {
        super();
    }

    public StringServiceException(String message) {
        super(message);
    }

    StringServiceException(Throwable cause) {
        super(cause);
    }

    StringServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
