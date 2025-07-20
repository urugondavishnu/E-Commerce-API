package com.urugondavishnu.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "email cant be blank")
    @Email
    private String email;

    @NotBlank(message = "password cant be blank")
    private String password;
}
