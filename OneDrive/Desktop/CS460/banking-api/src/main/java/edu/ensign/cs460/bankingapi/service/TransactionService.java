package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    TransactionResultDTO createTransaction(TransactionDTO transactionDTO);

    AccountBalanceDTO getAccountBalance(Long accountId);

    List<TransactionDTO> getTransactionHistory(Long accountId);

    TransactionResultDTO transfer(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
