package edu.ensign.cs460.bankingapi.exception;

public class TransferToSameAccountException extends RuntimeException {
    public TransferToSameAccountException(String message) {
        super(message);
    }
}
