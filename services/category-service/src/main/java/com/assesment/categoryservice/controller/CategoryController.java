package com.assesment.categoryservice.controller;


import com.assesment.categoryservice.dto.CategoryDto;
import com.assesment.categoryservice.dto.ResponseDTO;
import com.assesment.categoryservice.entity.Category;
import com.assesment.categoryservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add category
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(createdCategory);
    }

    //get category
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }

    //get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getall() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    //update category
    @PutMapping
    public ResponseDTO<CategoryDto> updateCategory(@RequestBody CategoryDto category) {
        CategoryDto created = categoryService.updateCategory(category);
        return new ResponseDTO<>(true,"Successfully Updated",created);
    }

    //delete category
    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteCategory(@PathVariable("id") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseDTO<>(true,"Successfully Deleted",null);
    }

}
