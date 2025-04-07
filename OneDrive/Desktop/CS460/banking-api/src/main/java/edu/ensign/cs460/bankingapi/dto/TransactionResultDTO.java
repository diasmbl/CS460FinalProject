package edu.ensign.cs460.bankingapi.dto;

import java.math.BigDecimal;

public class TransactionResultDTO {

    private Boolean success;
    private String message;
    private BigDecimal newBalance;

    public TransactionResultDTO() {}

    public TransactionResultDTO(Boolean success, String message, BigDecimal newBalance) {
        this.success = success;
        this.message = message;
        this.newBalance = newBalance;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
