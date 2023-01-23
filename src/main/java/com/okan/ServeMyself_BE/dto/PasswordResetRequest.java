package com.okan.ServeMyself_BE.dto;

import lombok.Data;

@Data
public class PasswordResetRequest {
    private String mail;
}