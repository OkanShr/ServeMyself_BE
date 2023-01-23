package com.okan.ServeMyself_BE.repository;

import com.okan.ServeMyself_BE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findUserByMail(String mail);
    Optional<User> findUserByUsername(String mail);

}
