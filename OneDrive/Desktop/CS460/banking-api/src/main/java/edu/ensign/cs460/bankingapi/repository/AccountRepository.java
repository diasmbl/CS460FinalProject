package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Example custom query methods:
    List<Account> findByUserId(Long userId);

    Optional<Account> findByAccountNumber(String accountNumber);

    // Add other methods as needed...
}
