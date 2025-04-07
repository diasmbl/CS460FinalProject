package edu.ensign.cs460.bankingapi.service;

import edu.ensign.cs460.bankingapi.dto.*;

public interface UserService {

    UserDTO registerUser(UserRegistrationDTO userDto);

    UserDTO authenticateUser(String username, String password);

    UserDTO updateUser(Long userId, UserUpdateDTO userUpdateDto);

    void deleteUser(Long userId);

    UserDTO getUserById(Long userId);
}
