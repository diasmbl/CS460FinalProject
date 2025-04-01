package edu.ensign.cs115.bankingapplication.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSFER")
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSFER_ID")
    private Long transferId;

    @Column(name = "FROM_ACCOUNT_ID", nullable = false)
    private Long fromAccountId;

    @Column(name = "TO_ACCOUNT_ID", nullable = false)
    private Long toAccountId;

    @Column(name = "AMOUNT", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "TRANSFER_DATE", nullable = false)
    private LocalDateTime transferDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "TRANSFER_TYPE", nullable = false)
    private String transferType;

    // ✅ Getters and Setters

    public Long getTransferId() { return transferId; }
    public void setTransferId(Long transferId) { this.transferId = transferId; }

    public Long getFromAccountId() { return fromAccountId; }
    public void setFromAccountId(Long fromAccountId) { this.fromAccountId = fromAccountId; }

    public Long getToAccountId() { return toAccountId; }
    public void setToAccountId(Long toAccountId) { this.toAccountId = toAccountId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDateTime transferDate) { this.transferDate = transferDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTransferType() { return transferType; }
    public void setTransferType(String transferType) { this.transferType = transferType; }
}
