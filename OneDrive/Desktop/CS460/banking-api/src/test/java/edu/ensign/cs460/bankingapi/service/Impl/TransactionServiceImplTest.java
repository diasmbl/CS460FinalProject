package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.exception.AccountNotFoundException;
import edu.ensign.cs460.bankingapi.models.Account;
import edu.ensign.cs460.bankingapi.repository.AccountRepository;
import edu.ensign.cs460.bankingapi.repository.TransactionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAccountBalance_shouldReturnCorrectBalance() {
        Account account = new Account();
        account.setAccountId(1L);
        account.setBalance(new BigDecimal("500.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        AccountBalanceDTO result = transactionService.getAccountBalance(1L);

        assertEquals(new BigDecimal("500.00"), result.getBalance());
    }

    @Test
    void getAccountBalance_shouldThrowWhenAccountNotFound() {
        when(accountRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> transactionService.getAccountBalance(999L));
    }

    @Test
    void transfer_shouldReturnSuccessPlaceholder() {
        TransactionResultDTO result = transactionService.transfer(1L, 2L, new BigDecimal("100.00"));
        assertTrue(result.getSuccess());
        assertTrue(result.getMessage().contains("placeholder"));
    }
}
