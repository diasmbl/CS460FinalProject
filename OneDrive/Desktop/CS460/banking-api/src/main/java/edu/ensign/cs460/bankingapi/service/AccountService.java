package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.AccountDto;
import edu.ensign.cs460.bankingapi.exception.InsufficientFundsException;
import edu.ensign.cs460.bankingapi.models.Account;

import java.math.BigDecimal;

public interface AccountService {

    Account createAccount(AccountDto accountDto);

    Account getAccountById(Long accountId);

    void deposit(Long accountId, BigDecimal amount);

    void withdraw(Long accountId, BigDecimal amount) throws InsufficientFundsException;

    void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) throws InsufficientFundsException;

    void closeAccount(Long accountId);
}
