package edu.ensign.cs115.bankingapplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "ACCOUNT_NUMBER", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(name = "ACCOUNT_TYPE", nullable = false, length = 50)
    private String accountType;

    @Column(name = "BALANCE", nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(name = "CREATION_DATE", nullable = false)
    private Timestamp creationDate;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    // Constructors
    public Account() {
    }

    // Getters and Setters

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
