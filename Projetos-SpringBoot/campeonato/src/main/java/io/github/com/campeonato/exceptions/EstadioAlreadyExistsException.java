package io.github.com.campeonato.exceptions;

public class EstadioAlreadyExistsException extends RuntimeException {
    public EstadioAlreadyExistsException(String message) {
        super(message);
    }

    public EstadioAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

