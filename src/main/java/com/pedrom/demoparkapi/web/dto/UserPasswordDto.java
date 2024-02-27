package com.pedrom.demoparkapi.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserPasswordDto {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
