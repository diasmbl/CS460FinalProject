package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.AccountDto;
import edu.ensign.cs460.bankingapi.exception.InsufficientFundsException;
import edu.ensign.cs460.bankingapi.models.Account;
import edu.ensign.cs460.bankingapi.repository.AccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount_shouldCreateAndReturnAccount() {
        AccountDto dto = new AccountDto();
        dto.setUserId(1L);
        dto.setAccountType("SAVINGS");
        dto.setInitialBalance(new BigDecimal("100.00"));

        when(accountRepository.findByAccountNumber(any())).thenReturn(Optional.empty());
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Account created = accountService.createAccount(dto);

        assertEquals(dto.getUserId(), created.getUserId());
        assertEquals(dto.getAccountType(), created.getAccountType());
        assertEquals(0, dto.getInitialBalance().compareTo(created.getBalance()));
        assertEquals("ACTIVE", created.getStatus());
    }

    @Test
    void getAccountById_shouldReturnAccount() {
        Account mockAccount = new Account();
        mockAccount.setAccountId(1L);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(mockAccount));

        Account result = accountService.getAccountById(1L);
        assertEquals(1L, result.getAccountId());
    }

    @Test
    void getAccountById_shouldThrowIfNotFound() {
        when(accountRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> accountService.getAccountById(99L));
    }

    @Test
    void deposit_shouldAddToBalance() {
        Account acc = new Account();
        acc.setBalance(new BigDecimal("100.00"));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(acc));

        accountService.deposit(1L, new BigDecimal("50.00"));
        assertEquals(new BigDecimal("150.00"), acc.getBalance());
    }

    @Test
    void withdraw_shouldSubtractFromBalance() {
        Account acc = new Account();
        acc.setBalance(new BigDecimal("100.00"));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(acc));

        accountService.withdraw(1L, new BigDecimal("40.00"));
        assertEquals(new BigDecimal("60.00"), acc.getBalance());
    }

    @Test
    void withdraw_shouldThrowIfInsufficientFunds() {
        Account acc = new Account();
        acc.setBalance(new BigDecimal("10.00"));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(acc));

        assertThrows(InsufficientFundsException.class, () ->
                accountService.withdraw(1L, new BigDecimal("50.00")));
    }

    @Test
    void transfer_shouldMoveMoney() {
        Account from = new Account();
        from.setBalance(new BigDecimal("100.00"));
        Account to = new Account();
        to.setBalance(new BigDecimal("50.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(from));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(to));

        accountService.transfer(1L, 2L, new BigDecimal("40.00"));

        assertEquals(new BigDecimal("60.00"), from.getBalance());
        assertEquals(new BigDecimal("90.00"), to.getBalance());
    }

    @Test
    void transfer_shouldThrowIfInsufficientFunds() {
        Account from = new Account();
        from.setBalance(new BigDecimal("10.00"));
        Account to = new Account();
        to.setBalance(new BigDecimal("50.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(from));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(to));

        assertThrows(InsufficientFundsException.class, () ->
                accountService.transfer(1L, 2L, new BigDecimal("20.00")));
    }

    @Test
    void closeAccount_shouldUpdateStatus() {
        Account acc = new Account();
        acc.setStatus("ACTIVE");
        when(accountRepository.findById(1L)).thenReturn(Optional.of(acc));

        accountService.closeAccount(1L);

        assertEquals("CLOSED", acc.getStatus());
    }
}
