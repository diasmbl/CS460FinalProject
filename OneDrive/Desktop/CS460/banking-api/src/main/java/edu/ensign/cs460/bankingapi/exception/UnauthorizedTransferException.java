package edu.ensign.cs460.bankingapi.exception;

public class UnauthorizedTransferException extends RuntimeException {
    public UnauthorizedTransferException(String message) {
        super(message);
    }
}
