package edu.ensign.cs115.bankingapplication.repository;

import edu.ensign.cs115.bankingapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface represents the UserRepository which extends JpaRepository.
 * It provides methods to perform CRUD operations and can also include custom queries.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This method is used to find a User by their username.
    // It returns an Optional<User> which can be empty if no User is found.
    Optional<User> findByUsername(String username);

    // This method is used to find a User by their email.
    // It returns an Optional<User> which can be empty if no User is found.
    Optional<User> findByEmail(String email);
}
