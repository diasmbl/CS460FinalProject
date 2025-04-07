package edu.ensign.cs460.bankingapi.exception;

public class UserDeletionException extends RuntimeException {
    public UserDeletionException(String message) {
        super(message);
    }
}
