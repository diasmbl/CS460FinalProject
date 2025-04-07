package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;
import edu.ensign.cs460.bankingapi.exception.*;
import edu.ensign.cs460.bankingapi.models.User;
import edu.ensign.cs460.bankingapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(UserRegistrationDTO userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username is already taken");
        }

        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email is already registered");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User saved = userRepository.save(user);
        return new UserDTO(saved.getId(), saved.getUsername(), saved.getEmail(), saved.getFullName());
    }

    @Override
    public UserDTO authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getFullName());
    }

    @Override
    public UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        user.setEmail(userUpdateDto.getEmail());
        user.setFullName(userUpdateDto.getFullName());

        User updated = userRepository.save(user);
        return new UserDTO(updated.getId(), updated.getUsername(), updated.getEmail(), updated.getFullName());
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new UserDeletionException("Unable to delete user due to related data");
        }
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getFullName());
    }
}
