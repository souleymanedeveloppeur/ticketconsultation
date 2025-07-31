package com.medical.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    private String firstName;

    private String lastName;

    private String email;

    //private String password;
}
