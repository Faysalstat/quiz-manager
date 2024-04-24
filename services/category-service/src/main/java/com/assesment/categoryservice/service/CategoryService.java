package com.assesment.categoryservice.service;

import com.assesment.categoryservice.dto.CategoryDto;
import com.assesment.categoryservice.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface CategoryService {
     CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);

     List<CategoryDto> getCategories();

     CategoryDto getCategory(Long categoryId);

     void deleteCategory(Long categoryId);

}
