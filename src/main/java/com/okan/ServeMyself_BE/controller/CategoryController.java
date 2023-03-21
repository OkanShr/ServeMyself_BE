package com.okan.ServeMyself_BE.controller;


import com.okan.ServeMyself_BE.model.Category;
import com.okan.ServeMyself_BE.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER','GUEST')")
    @GetMapping()
    public ResponseEntity<List> getCategories(){
        return ResponseEntity.ok(new ArrayList<>(categoryService.getCategory()));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.update(category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

}
