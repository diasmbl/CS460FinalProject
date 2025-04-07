package edu.ensign.cs460.bankingapi.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class TransactionDTO {

    @NotNull(message = "Account ID cannot be null")
    private Long accountId;

    @NotNull(message = "Destination Account ID cannot be null")
    private Long destinationAccountId;

    @DecimalMin(value = "0.01", inclusive = true, message = "Minimum transaction amount is 0.01")
    private BigDecimal amount;

    @NotBlank(message = "Transaction type is required")
    private String transactionType; // e.g., DEPOSIT, WITHDRAWAL, TRANSFER

    public TransactionDTO() {}

    public TransactionDTO(Long accountId, Long destinationAccountId, BigDecimal amount, String transactionType) {
        this.accountId = accountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Long destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
