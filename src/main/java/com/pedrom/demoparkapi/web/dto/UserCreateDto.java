package com.pedrom.demoparkapi.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserCreateDto{
    private String username;
    private String password;
}
