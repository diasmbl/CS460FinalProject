package edu.ensign.cs460.bankingapi.repository;

import edu.ensign.cs460.bankingapi.models.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

    List<TransferEntity> findByFromAccountId(Long sourceAccountId);

    List<TransferEntity> findByToAccountId(Long destinationAccountId);

    List<TransferEntity> findByTransferDateBetween(LocalDate startDate, LocalDate endDate);

    List<TransferEntity> findByStatus(String status);

    // Assuming you have a userId available in TransferEntity or through a join
    List<TransferEntity> findByUserId(Long userId);

    long countByTransferTypeAndTransferDateBetween(String transferType, LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(t.amount) FROM TransferEntity t WHERE t.fromAccountId = :accountId AND t.transferDate BETWEEN :startDate AND :endDate")
    BigDecimal sumTransferredByAccountIdAndDateRange(
            @Param("accountId") Long accountId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
