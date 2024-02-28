package com.pedrom.demoparkapi.web.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserResponseDto {
    private UUID id;
    private String username;
    private String role;
}
