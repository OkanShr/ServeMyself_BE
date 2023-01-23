package com.okan.ServeMyself_BE.service;

import com.okan.ServeMyself_BE.dto.LoginModel;
import com.okan.ServeMyself_BE.dto.RegisterModel;
import com.okan.ServeMyself_BE.dto.TokenDTO;
import com.okan.ServeMyself_BE.dto.UserDTO;
import com.okan.ServeMyself_BE.exception.WrongCredientalsException;
import com.okan.ServeMyself_BE.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;
    private final ModelMapper modelMapper;

    public TokenDTO tryLogin(LoginModel loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenDTO
                    .builder()
                    .accessToken(tokenService.generateToken(auth))
                    .user(modelMapper.map(userService.findUserByUsername(loginRequest.getUsername()), UserDTO.class))
                    .build();
        } catch (final BadCredentialsException badCredentialsException) {
            throw new WrongCredientalsException("Invalid Username or Password");
        }

    }


//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (AnonymousAuthenticationToken.class).isAssignableFrom(authentication);
//    }
//



    public User getAuthenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findUserByUsername(username);
    }

//    public boolean checkForPermission(Long id) {
//        return getAuthenticatedUser().getId().equals(id);
//    }

    public User tryRegister(RegisterModel registerModel) {
        return userService.create(
                User.builder()
                        .username(registerModel.getUsername())
                        .mail(registerModel.getMail())
                        .name(registerModel.getName())
                        .surname(registerModel.getSurname())
                        .password(registerModel.getPassword())
                        .build());
    }
}