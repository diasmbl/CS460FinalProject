package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.TransactionEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void testFindById() {
        // Given: a TransactionEntity instance with test data
        TransactionEntity transaction = new TransactionEntity();
        transaction.setTransactionId(1L);
        transaction.setAccountId(100L);
        transaction.setType("Deposit");
        transaction.setAmount(new BigDecimal("150.00"));
        transaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        transaction.setStatus("Completed");
        transaction.setDescription("Initial deposit");

        // Define behavior: when findById is called with 1L, return our test transaction
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        // When: the method is invoked
        Optional<TransactionEntity> found = transactionRepository.findById(1L);

        // Then: assert that the transaction was found and has expected values
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getTransactionId()).isEqualTo(1L);
        assertThat(found.get().getType()).isEqualTo("Deposit");
        assertThat(found.get().getAmount()).isEqualByComparingTo(new BigDecimal("150.00"));
    }
}
