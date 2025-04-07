package edu.ensign.cs460.bankingapi.repository;

import edu.ensign.cs460.bankingapi.models.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void testFindByAccountNumber() {
        // Given: Create a test Account instance
        Account account = new Account();
        account.setAccountId(1L);
        account.setUserId(100L);
        account.setAccountNumber("ACC123456");
        account.setAccountType("Checking");
        account.setBalance(new BigDecimal("1000.00"));
        account.setCreationDate(new Timestamp(System.currentTimeMillis()));
        account.setStatus("Active");

        // Define behavior: when findByAccountNumber is called, return the test account wrapped in Optional.
        when(accountRepository.findByAccountNumber("ACC123456"))
                .thenReturn(Optional.of(account));

        // When: the method is invoked
        Optional<Account> found = accountRepository.findByAccountNumber("ACC123456");

        // Then: Verify the returned account has expected values
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getAccountNumber()).isEqualTo("ACC123456");
        assertThat(found.get().getAccountType()).isEqualTo("Checking");
        assertThat(found.get().getBalance()).isEqualByComparingTo(new BigDecimal("1000.00"));
    }

    @Test
    public void testFindByUserId() {
        // Given: Create two test Account objects for the same user
        Account account1 = new Account();
        account1.setAccountId(1L);
        account1.setUserId(100L);
        account1.setAccountNumber("ACC123456");
        account1.setAccountType("Checking");
        account1.setBalance(new BigDecimal("1000.00"));
        account1.setCreationDate(new Timestamp(System.currentTimeMillis()));
        account1.setStatus("Active");

        Account account2 = new Account();
        account2.setAccountId(2L);
        account2.setUserId(100L);
        account2.setAccountNumber("ACC654321");
        account2.setAccountType("Savings");
        account2.setBalance(new BigDecimal("5000.00"));
        account2.setCreationDate(new Timestamp(System.currentTimeMillis()));
        account2.setStatus("Active");

        // Assume that your repository has a custom query method like findByUserId(Long userId)
        // For this test, we will simulate that behavior
        List<Account> accountsForUser = Arrays.asList(account1, account2);
        when(accountRepository.findByUserId(100L)).thenReturn(accountsForUser);

        // When: the method is invoked
        List<Account> foundAccounts = accountRepository.findByUserId(100L);

        // Then: Verify that two accounts are returned and their details are correct
        assertThat(foundAccounts).hasSize(2);
        assertThat(foundAccounts.get(0).getUserId()).isEqualTo(100L);
        assertThat(foundAccounts.get(1).getUserId()).isEqualTo(100L);
    }
}
