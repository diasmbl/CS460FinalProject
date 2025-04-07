package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;

import java.util.List;

public interface LoanService {

    LoanApplicationResultDTO applyForLoan(LoanApplicationDTO application);

    LoanDetailsDTO getLoanDetails(Long loanId);

    PaymentResultDTO makeRepayment(LoanRepaymentDTO repaymentDto);

    List<LoanDetailsDTO> getUserLoans(Long userId);
}
