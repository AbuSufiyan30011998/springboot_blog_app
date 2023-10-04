package com.ashokit.controller;


import com.ashokit.payload.ApiResponce;
import com.ashokit.payload.CategoryDto;
import com.ashokit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateogDto) {
        CategoryDto createCategory = this.categoryService.createCategory(cateogDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    // update

    @PutMapping("/category/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
                                                      @PathVariable Long catId) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    // delete

    @DeleteMapping("/category/{catId}")
    public ResponseEntity<ApiResponce> deleteCategory(@PathVariable Long catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponce>(new ApiResponce("category is deleted successfully !!", true),
                HttpStatus.OK);
    }
    // get

    @GetMapping("/category/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long catId) {
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

    }

    // get all
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

}
