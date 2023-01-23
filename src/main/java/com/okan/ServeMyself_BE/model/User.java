package com.okan.ServeMyself_BE.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private String profileImageUrl;
    // this bool is to prevent login while true
    private boolean resetPassword;
    private Integer resetPasswordCode;

    @Enumerated(EnumType.STRING)


    private Role role;

}
