package edu.ensign.cs115.bankingapplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    @Column(name = "AMOUNT", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "TRANSACTION_DATE", nullable = false)
    private Timestamp transactionDate;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    // Constructors
    public TransactionEntity() {
    }

    // Getters and setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
