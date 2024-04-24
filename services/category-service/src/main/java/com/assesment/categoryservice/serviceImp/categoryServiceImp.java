package com.assesment.categoryservice.serviceImp;

import com.assesment.categoryservice.dto.CategoryDto;
import com.assesment.categoryservice.entity.Category;
import com.assesment.categoryservice.mapper.CategoryMapper;
import com.assesment.categoryservice.repository.CategoryRepository;
import com.assesment.categoryservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Slf4j
public class categoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toCreateEntity(categoryDto);
        CategoryDto createdCategory = categoryMapper.toDto(categoryRepository.save(category));
        return createdCategory;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toUpdateEntity(categoryDto);
        CategoryDto createdCategory = categoryMapper.toDto(categoryRepository.saveAndFlush(category));
        return createdCategory;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        if(!categories.isEmpty()){
            for(Category category:categories){
                categoryDtos.add(categoryMapper.toDto(category));
            }
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        return categoryMapper.toDto(categoryRepository.findById(categoryId).orElseThrow());
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
