package com.okan.ServeMyself_BE.controller;

import com.okan.ServeMyself_BE.model.Orders;
import com.okan.ServeMyself_BE.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {
    private  final OrderService orderService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping()
    public ResponseEntity<List> getOrders(){return ResponseEntity.ok(new ArrayList<>(orderService.getOrders()));}


    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody Orders tray){
        return ResponseEntity.ok(orderService.update(tray));}



    @PreAuthorize("hasAnyAuthority('USER','GUEST')")
    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Orders tray){
        return ResponseEntity.ok(orderService.create(tray));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
