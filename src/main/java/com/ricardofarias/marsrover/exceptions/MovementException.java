package com.ricardofarias.marsrover.exceptions;

public class MovementException extends RuntimeException {
    public MovementException() {
        super();
    }

    public MovementException(String message) {
        super(message);
    }

    public MovementException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovementException(Throwable cause) {
        super(cause);
    }
}
