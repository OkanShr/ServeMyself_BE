package com.okan.ServeMyself_BE.dto;


import lombok.Data;

@Data
public class PasswordResetModel {
    private String mail;
    private String password;
    private Integer code;
}
