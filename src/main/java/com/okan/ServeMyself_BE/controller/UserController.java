package com.okan.ServeMyself_BE.controller;

import com.okan.ServeMyself_BE.dto.PasswordResetModel;
import com.okan.ServeMyself_BE.dto.PasswordResetRequest;
import com.okan.ServeMyself_BE.dto.RegisterModel;
import com.okan.ServeMyself_BE.dto.UserDTO;
import com.okan.ServeMyself_BE.model.User;
import com.okan.ServeMyself_BE.repository.UserRepository;
import com.okan.ServeMyself_BE.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN')")
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers().stream()
                .map(x -> modelMapper.map(x, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @PostMapping("/create-user-by-role")
    public ResponseEntity<UserDTO> createUserByRole(@RequestBody RegisterModel registerModel) {
        return ResponseEntity.ok(modelMapper.map(userService.create(registerModel), UserDTO.class));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(modelMapper.map(userService.update(user), UserDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-request")
    public ResponseEntity<Void> resetMail(@RequestBody PasswordResetRequest passwordResetRequest) {
        userService.resetPasswordRequestCodeGenerate(passwordResetRequest.getMail());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody PasswordResetModel passwordResetModel) {
        userService.resetPassword(passwordResetModel);
        return ResponseEntity.ok().build();
    }
}
