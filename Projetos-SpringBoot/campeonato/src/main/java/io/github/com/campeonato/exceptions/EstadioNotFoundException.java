package io.github.com.campeonato.exceptions;

public class EstadioNotFoundException extends RuntimeException {
    public EstadioNotFoundException(String message) {
        super(message);
    }

    public EstadioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

