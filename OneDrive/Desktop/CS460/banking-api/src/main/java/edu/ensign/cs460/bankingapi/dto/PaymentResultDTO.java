package edu.ensign.cs460.bankingapi.dto;

public class PaymentResultDTO {
    private Boolean success;
    private String message;

    public PaymentResultDTO() {}

    public PaymentResultDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
