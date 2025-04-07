package edu.ensign.cs460.bankingapi.dto;

import java.math.BigDecimal;

public class TransferResultDTO {

    private boolean success;
    private String message;
    private BigDecimal newSourceBalance;
    private BigDecimal newDestinationBalance;

    public TransferResultDTO() {}

    public TransferResultDTO(boolean success, String message, BigDecimal newSourceBalance, BigDecimal newDestinationBalance) {
        this.success = success;
        this.message = message;
        this.newSourceBalance = newSourceBalance;
        this.newDestinationBalance = newDestinationBalance;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getNewSourceBalance() {
        return newSourceBalance;
    }

    public void setNewSourceBalance(BigDecimal newSourceBalance) {
        this.newSourceBalance = newSourceBalance;
    }

    public BigDecimal getNewDestinationBalance() {
        return newDestinationBalance;
    }

    public void setNewDestinationBalance(BigDecimal newDestinationBalance) {
        this.newDestinationBalance = newDestinationBalance;
    }
}
