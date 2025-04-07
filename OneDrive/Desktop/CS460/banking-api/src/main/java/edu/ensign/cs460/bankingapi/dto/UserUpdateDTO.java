package edu.ensign.cs460.bankingapi.dto;

public class UserUpdateDTO {

    private String email;
    private String fullName;

    public UserUpdateDTO() {}

    public UserUpdateDTO(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
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
}
