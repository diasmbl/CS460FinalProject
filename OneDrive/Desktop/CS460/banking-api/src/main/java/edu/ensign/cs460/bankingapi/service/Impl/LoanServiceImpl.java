package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public LoanApplicationResultDTO applyForLoan(LoanApplicationDTO application) {
        // TODO: Process and validate application, create loan, return result
        return new LoanApplicationResultDTO(true, "Loan approved (placeholder)", 1L);
    }

    @Override
    public LoanDetailsDTO getLoanDetails(Long loanId) {
        // TODO: Fetch and return loan details
        return new LoanDetailsDTO();
    }

    @Override
    public PaymentResultDTO makeRepayment(LoanRepaymentDTO repaymentDto) {
        // TODO: Validate and process repayment
        return new PaymentResultDTO(true, "Repayment successful (placeholder)");
    }

    @Override
    public List<LoanDetailsDTO> getUserLoans(Long userId) {
        // TODO: Fetch all loans by user ID
        return List.of(); // Placeholder
    }
}
