package edu.ensign.cs460.bankingapi.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class AccountDto {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotBlank(message = "Account type is required")
    private String accountType;

    @DecimalMin(value = "0.0", inclusive = false, message = "Initial balance must be greater than 0")
    private BigDecimal initialBalance;

    public AccountDto() {}

    public AccountDto(Long userId, String accountType, BigDecimal initialBalance) {
        this.userId = userId;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public BigDecimal getInitialBalance() { return initialBalance; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
}
