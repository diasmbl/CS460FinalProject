package edu.ensign.cs460.bankingapi.repository;

import edu.ensign.cs460.bankingapi.models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    // Custom query methods can be added here if needed
}
