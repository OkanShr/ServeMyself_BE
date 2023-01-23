package com.okan.ServeMyself_BE.dto;

import com.okan.ServeMyself_BE.model.Role;
import lombok.Data;

@Data
public class RegisterModel {
    private String username;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private Role role;
}