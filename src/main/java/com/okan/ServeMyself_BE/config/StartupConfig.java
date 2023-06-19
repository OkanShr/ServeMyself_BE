package com.okan.ServeMyself_BE.config;


import com.okan.ServeMyself_BE.model.Role;
import com.okan.ServeMyself_BE.model.User;
import com.okan.ServeMyself_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
//           userService.create(User.builder().username("okanshr").password("okanshr").name("Okan").surname("Sechrin").mail("Okanshr@hotmail.com").build(), Role.SUPER_ADMIN);
//           userService.create(User.builder().username("Guest").password("Guest12345!").name("Guest").surname("Guest").mail("Guest@mail").build(), Role.USER);
        //   userService.create(User.builder().username("222").password("222").name("user2").surname("user2").mail("user2@mail").build(), Role.USER);
    }
}

