package com.assesment.categoryservice.mapper;


import com.assesment.categoryservice.dto.CategoryDto;
import com.assesment.categoryservice.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto toDto(Category entity) {
        if (entity == null) {
            return null;
        }
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        return dto;
    }

    public Category toCreateEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }

        Category entity = new Category();
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        return entity;
    }
    public Category toUpdateEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }

        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        return entity;
    }


}
