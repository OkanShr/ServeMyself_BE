package com.okan.ServeMyself_BE.repository;

import com.okan.ServeMyself_BE.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}