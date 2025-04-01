package edu.ensign.cs115.bankingapplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LOAN")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_ID")
    private Long loanId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "LOAN_TYPE", nullable = false, length = 50)
    private String loanType;

    @Column(name = "AMOUNT", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "INTEREST_RATE", nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name = "MONTHLY_REPAYMENT_AMOUNT", nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyRepaymentAmount;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    // ✅ Getters & Setters

    public Long getLoanId() { return loanId; }
    public void setLoanId(Long loanId) { this.loanId = loanId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public BigDecimal getInterestRate() { return interestRate; }
    public void setInterestRate(BigDecimal interestRate) { this.interestRate = interestRate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public BigDecimal getMonthlyRepaymentAmount() { return monthlyRepaymentAmount; }
    public void setMonthlyRepaymentAmount(BigDecimal monthlyRepaymentAmount) { this.monthlyRepaymentAmount = monthlyRepaymentAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
