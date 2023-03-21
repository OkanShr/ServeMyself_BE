package com.okan.ServeMyself_BE.service;

import com.okan.ServeMyself_BE.exception.UserNotFoundException;
import com.okan.ServeMyself_BE.model.Category;
import com.okan.ServeMyself_BE.model.User;
import com.okan.ServeMyself_BE.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category create(Category category) { return categoryRepository.save(category);}

    public List<Category> getCategory() {return categoryRepository.findAll();}

    public Category update(Category category) {
        Category existing = findCategoryByID(category.getId());
        existing.setCategoryname(category.getCategoryname());
        return categoryRepository.save(category);
    }

    public Category findCategoryByID(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Category Not Found!"));
    }

    public boolean doesCategoryExistByID(Long id){return categoryRepository.findById(id).isPresent();}

    public void deleteCategory(Long id){
        if(doesCategoryExistByID(id)){
            categoryRepository.deleteById(id);
        }else{
            throw new UserNotFoundException("Category Doesnt Exist!");
        }
    }

}
