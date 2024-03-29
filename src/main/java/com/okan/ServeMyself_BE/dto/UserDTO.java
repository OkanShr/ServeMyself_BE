package com.okan.ServeMyself_BE.dto;

import com.okan.ServeMyself_BE.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private String profileImageUrl;
    private boolean resetPassword;
    private Role role;
}
