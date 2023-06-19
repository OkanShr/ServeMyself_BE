package com.okan.ServeMyself_BE.controller;

import com.okan.ServeMyself_BE.model.Orders;
import com.okan.ServeMyself_BE.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor

public class HistoryController {
    private  final OrderService orderService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/{username}")
    public List<Orders> getuserhistory(@PathVariable String username){
        return orderService.getOrdersByUsername(username);

    }
}