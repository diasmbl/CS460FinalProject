package edu.ensign.cs115.bankingapplication.models;

import jakarta.persistence.*;
import java.util.Date;

/**
 * This class represents the User entity in the database.
 */
@Entity
@Table(name = "USER")
public class User {
    // Unique identifier for the User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    // Username of the User, must be unique
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    // Password of the User
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    // Email of the User, must be unique
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    // Full name of the User
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    // Date of birth of the User
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    // Registration date of the User
    @Column(name = "REGISTRATION_DATE", nullable = false)
    private Date registrationDate;

    // No-argument constructor
    public User() {
    }

    // All-argument constructor
    public User(Long userId, String username, String password, String email,
                String fullName, Date dateOfBirth, Date registrationDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
    }

    // Getters and setters for all fields
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
