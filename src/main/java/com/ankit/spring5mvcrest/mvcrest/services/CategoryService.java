package com.ankit.spring5mvcrest.mvcrest.services;

import com.ankit.spring5mvcrest.mvcrest.api.v1.model.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
