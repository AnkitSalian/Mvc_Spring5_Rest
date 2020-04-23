package com.ankit.spring5mvcrest.mvcrest.repositories;

import com.ankit.spring5mvcrest.mvcrest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
