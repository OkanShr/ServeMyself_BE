package com.okan.ServeMyself_BE.repository;

import com.okan.ServeMyself_BE.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByUsername(String username);
}
