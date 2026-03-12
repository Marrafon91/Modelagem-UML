package io.github.com.campeonato.exceptions;

public class CampeonatoNotFoundException extends RuntimeException {
    public CampeonatoNotFoundException(String message) {
        super(message);
    }

    public CampeonatoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

