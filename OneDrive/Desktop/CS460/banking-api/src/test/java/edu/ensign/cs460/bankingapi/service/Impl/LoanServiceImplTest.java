package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.repository.LoanRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceImplTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void applyForLoan_shouldReturnApprovalPlaceholder() {
        LoanApplicationDTO app = new LoanApplicationDTO(1L, null, 12, "Auto");
        LoanApplicationResultDTO result = loanService.applyForLoan(app);

        assertTrue(result.getApproved());
        assertEquals("Loan approved (placeholder)", result.getMessage());
    }

    @Test
    void getUserLoans_shouldReturnEmptyListInitially() {
        List<LoanDetailsDTO> loans = loanService.getUserLoans(1L);
        assertTrue(loans.isEmpty());
    }

    @Test
    void makeRepayment_shouldReturnSuccess() {
        LoanRepaymentDTO repayment = new LoanRepaymentDTO(1L, null);
        PaymentResultDTO result = loanService.makeRepayment(repayment);

        assertTrue(result.getSuccess());
    }
}
