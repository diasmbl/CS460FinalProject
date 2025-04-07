package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.exception.*;
import edu.ensign.cs460.bankingapi.models.Account;
import edu.ensign.cs460.bankingapi.repository.AccountRepository;
import edu.ensign.cs460.bankingapi.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository,
                                  TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public TransactionResultDTO createTransaction(TransactionDTO dto) {
        // Placeholder for future full implementation
        return new TransactionResultDTO(true, "Transaction created (placeholder)", BigDecimal.ZERO);
    }

    @Override
    public AccountBalanceDTO getAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + accountId));
        return new AccountBalanceDTO(account.getAccountId(), account.getBalance());
    }

    @Override
    public List<TransactionDTO> getTransactionHistory(Long accountId) {
        // Placeholder: convert real transaction entities to DTOs
        return List.of(); // empty for now
    }

    @Override
    public TransactionResultDTO transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        // Placeholder for transfer logic
        return new TransactionResultDTO(true, "Transfer completed (placeholder)", BigDecimal.ZERO);
    }
}
