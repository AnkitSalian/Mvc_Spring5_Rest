package com.ankit.spring5mvcrest.mvcrest.services;

import com.ankit.spring5mvcrest.mvcrest.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
