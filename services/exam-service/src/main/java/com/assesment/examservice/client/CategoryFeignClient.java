package com.assesment.examservice.client;

import com.assesment.examservice.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service")
public interface CategoryFeignClient {
    @GetMapping("/category/{id}")
    public CategoryDto getCategory(@PathVariable("id") Long categoryId);

}
