package com.okan.ServeMyself_BE.controller;

import com.okan.ServeMyself_BE.dto.LoginModel;
import com.okan.ServeMyself_BE.dto.RegisterModel;
import com.okan.ServeMyself_BE.dto.TokenDTO;
import com.okan.ServeMyself_BE.dto.UserDTO;
import com.okan.ServeMyself_BE.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterModel registerModel)
    {
        return ResponseEntity.ok(modelMapper.map(authService.tryRegister(registerModel), UserDTO.class));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginModel loginModel)
    {
        return ResponseEntity.ok(authService.tryLogin(loginModel));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMyself()
    {
        return ResponseEntity.ok(modelMapper.map(authService.getAuthenticatedUser(), UserDTO.class));
    }


}

