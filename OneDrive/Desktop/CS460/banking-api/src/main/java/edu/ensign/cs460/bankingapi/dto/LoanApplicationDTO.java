package edu.ensign.cs460.bankingapi.dto;

import java.math.BigDecimal;

public class LoanApplicationDTO {
    private Long userId;
    private BigDecimal amountRequested;
    private Integer termMonths;
    private String loanType;

    public LoanApplicationDTO() {}

    public LoanApplicationDTO(Long userId, BigDecimal amountRequested, Integer termMonths, String loanType) {
        this.userId = userId;
        this.amountRequested = amountRequested;
        this.termMonths = termMonths;
        this.loanType = loanType;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public BigDecimal getAmountRequested() { return amountRequested; }
    public void setAmountRequested(BigDecimal amountRequested) { this.amountRequested = amountRequested; }

    public Integer getTermMonths() { return termMonths; }
    public void setTermMonths(Integer termMonths) { this.termMonths = termMonths; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
}
