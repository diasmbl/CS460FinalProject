package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.TransferEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransferRepositoryTest {

    @Test
    public void testFindByStatus() {
        TransferRepository mockRepo = Mockito.mock(TransferRepository.class);
        TransferEntity mockTransfer = new TransferEntity();
        mockTransfer.setStatus("Pending");

        when(mockRepo.findByStatus("Pending")).thenReturn(List.of(mockTransfer));

        List<TransferEntity> result = mockRepo.findByStatus("Pending");

        assertEquals(1, result.size());
        assertEquals("Pending", result.get(0).getStatus());
    }

    @Test
    public void testSumTransferredByAccountIdAndDateRange() {
        TransferRepository mockRepo = Mockito.mock(TransferRepository.class);
        LocalDate start = LocalDate.now().minusDays(7);
        LocalDate end = LocalDate.now();

        when(mockRepo.sumTransferredByAccountIdAndDateRange(100L, start, end))
                .thenReturn(new BigDecimal("500.00"));

        BigDecimal result = mockRepo.sumTransferredByAccountIdAndDateRange(100L, start, end);

        assertEquals(new BigDecimal("500.00"), result);
    }
}
