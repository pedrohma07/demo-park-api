package com.pedrom.demoparkapi.web.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserPasswordDto {
    @NotBlank
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String currentPassword;
    @NotBlank
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String newPassword;
    @NotBlank
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String confirmPassword;
}
