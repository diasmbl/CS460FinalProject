package edu.ensign.cs460.bankingapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDetailsDTO {
    private BigDecimal outstandingBalance;
    private BigDecimal interestRate;
    private LocalDate nextPaymentDate;
    private BigDecimal nextPaymentAmount;

    public LoanDetailsDTO() {}

    public LoanDetailsDTO(BigDecimal outstandingBalance, BigDecimal interestRate, LocalDate nextPaymentDate, BigDecimal nextPaymentAmount) {
        this.outstandingBalance = outstandingBalance;
        this.interestRate = interestRate;
        this.nextPaymentDate = nextPaymentDate;
        this.nextPaymentAmount = nextPaymentAmount;
    }

    public BigDecimal getOutstandingBalance() { return outstandingBalance; }
    public void setOutstandingBalance(BigDecimal outstandingBalance) { this.outstandingBalance = outstandingBalance; }

    public BigDecimal getInterestRate() { return interestRate; }
    public void setInterestRate(BigDecimal interestRate) { this.interestRate = interestRate; }

    public LocalDate getNextPaymentDate() { return nextPaymentDate; }
    public void setNextPaymentDate(LocalDate nextPaymentDate) { this.nextPaymentDate = nextPaymentDate; }

    public BigDecimal getNextPaymentAmount() { return nextPaymentAmount; }
    public void setNextPaymentAmount(BigDecimal nextPaymentAmount) { this.nextPaymentAmount = nextPaymentAmount; }
}
