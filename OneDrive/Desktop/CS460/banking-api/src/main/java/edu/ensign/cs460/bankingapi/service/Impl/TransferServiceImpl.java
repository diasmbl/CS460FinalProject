package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.TransferRequestDTO;
import edu.ensign.cs460.bankingapi.dto.TransferResultDTO;
import edu.ensign.cs460.bankingapi.exception.*;
import edu.ensign.cs460.bankingapi.models.Account;
import edu.ensign.cs460.bankingapi.repository.AccountRepository;
import edu.ensign.cs460.bankingapi.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    @Autowired
    public TransferServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository,
                               TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @Override
    @Transactional
    public TransferResultDTO initiateTransfer(TransferRequestDTO transferRequest) {
        Long fromId = transferRequest.getFromAccountId();
        Long toId = transferRequest.getToAccountId();
        BigDecimal amount = transferRequest.getAmount();

        if (fromId.equals(toId)) throw new TransferToSameAccountException("Cannot transfer to the same account");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidTransferAmountException("Transfer amount must be greater than zero");

        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));

        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found"));

        if (fromAccount.getBalance().compareTo(amount) < 0)
            throw new InsufficientFundsException("Insufficient funds in source account");

        // Perform transfer
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        try {
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
            // Optionally record a transaction entity here
        } catch (Exception e) {
            throw new TransferFailedException("Transfer failed due to system error");
        }

        return new TransferResultDTO(true, "Transfer successful",
                fromAccount.getBalance(), toAccount.getBalance());
    }
}
