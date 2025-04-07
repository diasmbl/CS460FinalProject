package edu.ensign.cs460.bankingapi.dto;

import java.math.BigDecimal;

public class LoanRepaymentDTO {
    private Long loanId;
    private BigDecimal paymentAmount;

    public LoanRepaymentDTO() {}

    public LoanRepaymentDTO(Long loanId, BigDecimal paymentAmount) {
        this.loanId = loanId;
        this.paymentAmount = paymentAmount;
    }

    public Long getLoanId() { return loanId; }
    public void setLoanId(Long loanId) { this.loanId = loanId; }

    public BigDecimal getPaymentAmount() { return paymentAmount; }
    public void setPaymentAmount(BigDecimal paymentAmount) { this.paymentAmount = paymentAmount; }
}
