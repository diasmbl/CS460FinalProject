package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    List<LoanEntity> findByUserId(Long userId);

    List<LoanEntity> findByStatus(String status);

    List<LoanEntity> findByLoanType(String loanType);

    List<LoanEntity> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<LoanEntity> findByEndDateBetween(LocalDate startDate, LocalDate endDate);

    long countByLoanType(String loanType);

    @Query("SELECT SUM(l.amount) FROM LoanEntity l WHERE l.status = :status")
    BigDecimal sumByStatus(@Param("status") String status);

    @Query("SELECT AVG(l.interestRate) FROM LoanEntity l WHERE l.loanType = :loanType")
    double averageInterestRateByLoanType(@Param("loanType") String loanType);
}
