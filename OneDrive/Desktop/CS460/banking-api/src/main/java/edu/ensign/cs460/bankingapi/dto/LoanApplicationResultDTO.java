package edu.ensign.cs460.bankingapi.dto;

public class LoanApplicationResultDTO {
    private Boolean approved;
    private String message;
    private Long loanId;

    public LoanApplicationResultDTO() {}

    public LoanApplicationResultDTO(Boolean approved, String message, Long loanId) {
        this.approved = approved;
        this.message = message;
        this.loanId = loanId;
    }

    public Boolean getApproved() { return approved; }
    public void setApproved(Boolean approved) { this.approved = approved; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getLoanId() { return loanId; }
    public void setLoanId(Long loanId) { this.loanId = loanId; }
}
