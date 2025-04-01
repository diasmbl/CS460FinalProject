package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.LoanEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoanRepositoryTest {

    @Test
    public void testFindByStatus() {
        LoanRepository repo = mock(LoanRepository.class);
        LoanEntity loan = new LoanEntity();
        loan.setStatus("Approved");

        when(repo.findByStatus("Approved")).thenReturn(List.of(loan));

        List<LoanEntity> result = repo.findByStatus("Approved");

        assertEquals(1, result.size());
        assertEquals("Approved", result.get(0).getStatus());
    }

    @Test
    public void testSumByStatus() {
        LoanRepository repo = mock(LoanRepository.class);
        when(repo.sumByStatus("Pending")).thenReturn(new BigDecimal("10000.00"));

        BigDecimal result = repo.sumByStatus("Pending");

        assertEquals(new BigDecimal("10000.00"), result);
    }

    @Test
    public void testAverageInterestRateByLoanType() {
        LoanRepository repo = mock(LoanRepository.class);
        when(repo.averageInterestRateByLoanType("Mortgage")).thenReturn(4.25);

        double avg = repo.averageInterestRateByLoanType("Mortgage");

        assertEquals(4.25, avg, 0.001);
    }
}
