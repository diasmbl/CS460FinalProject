package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.exception.*;
import edu.ensign.cs460.bankingapi.models.User;
import edu.ensign.cs460.bankingapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;

    @InjectMocks private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_shouldCreateNewUser() {
        UserRegistrationDTO dto = new UserRegistrationDTO("testUser", "pass123", "test@example.com");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("pass123")).thenReturn("encodedPass");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername("testUser");
        savedUser.setEmail("test@example.com");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDTO result = userService.registerUser(dto);

        assertEquals("testUser", result.getUsername());
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    void authenticateUser_shouldReturnUserDTO_ifValidCredentials() {
        User user = new User();
        user.setUsername("john");
        user.setPassword("hashed");

        when(userRepository.findByUsername("john")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("secret", "hashed")).thenReturn(true);

        UserDTO result = userService.authenticateUser("john", "secret");

        assertEquals("john", result.getUsername());
    }

    @Test
    void deleteUser_shouldThrowIfUserDoesNotExist() {
        when(userRepository.existsById(10L)).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(10L));
    }
}
