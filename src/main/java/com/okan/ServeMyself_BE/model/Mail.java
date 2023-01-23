package com.okan.ServeMyself_BE.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Mail {
    private String to;
    private String subject;
    private String text;
}