package com.okan.ServeMyself_BE.repository;

import com.okan.ServeMyself_BE.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findItemByName(String name);

}
