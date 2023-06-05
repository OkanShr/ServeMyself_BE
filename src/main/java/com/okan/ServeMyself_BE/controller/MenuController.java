package com.okan.ServeMyself_BE.controller;

import com.okan.ServeMyself_BE.model.Menu;
import com.okan.ServeMyself_BE.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor


public class MenuController {
    private final MenuService menuService;


    @PreAuthorize("hasAnyAuthority('ADMIN','USER','GUEST')")
    @GetMapping()
    public ResponseEntity<List> getMenu() {
        return ResponseEntity.ok(new ArrayList<>(menuService.getMenu()));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/{restaurant}")
    public List<Menu> getMenuByRestaurant(@PathVariable String restaurant){
        return menuService.getMenuByRestaurant(restaurant);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create-item")
    public ResponseEntity<?> createItem(@RequestBody Menu item){
        return ResponseEntity.ok(menuService.create(item));
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Menu item) {
        return ResponseEntity.ok(menuService.update(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable Long id){
        menuService.deleteItem(id);
        return  ResponseEntity.ok().build();
    }

}
