package edu.ensign.cs460.bankingapi.exception;

public class InvalidTransferAmountException extends RuntimeException {
    public InvalidTransferAmountException(String message) {
        super(message);
    }
}
