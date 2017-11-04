package codebase.ingatmmanager.service;

public class IngAtmManagerServiceException extends RuntimeException {

    public IngAtmManagerServiceException(String message) {
        super(message);
    }

    public IngAtmManagerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
