package com.ankit.spring5mvcrest.mvcrest.controllers.v1;

import com.ankit.spring5mvcrest.mvcrest.api.v1.model.CategoryDTO;
import com.ankit.spring5mvcrest.mvcrest.services.CategoryService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryControllerTest {

    public static final String NAME = "Jim";

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testListCategories() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName(NAME);

        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(2L);
        categoryDTO1.setName("Bob");

        List<CategoryDTO> categoryDTOS = Arrays.asList(categoryDTO, categoryDTO1);

        Mockito.when(categoryService.getAllCategories()).thenReturn(categoryDTOS);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.categories", IsCollectionWithSize.hasSize(2)));

    }

    @Test
    public void testGetByNameCategories() throws Exception {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName(NAME);

        Mockito.when(categoryService.getCategoryByName(ArgumentMatchers.anyString())).thenReturn(categoryDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories/Jim")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.equalTo(NAME)));
    }
}