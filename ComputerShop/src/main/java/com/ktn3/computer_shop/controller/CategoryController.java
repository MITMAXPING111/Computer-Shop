package com.ktn3.computer_shop.controller;

import com.ktn3.computer_shop.dto.request.category.ReqCreateCategory;
import com.ktn3.computer_shop.dto.request.category.ReqUpdateCategory;
import com.ktn3.computer_shop.dto.response.category.ResCategory;
import com.ktn3.computer_shop.dto.response.category.ResCreateCategory;
import com.ktn3.computer_shop.dto.response.category.ResUpdateCategory;
import com.ktn3.computer_shop.entity.Category;
import com.ktn3.computer_shop.mapper.CategoryMapper;
import com.ktn3.computer_shop.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/api/v1/danh-muc")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @PostMapping("")
    public ResponseEntity<ResCreateCategory> createCategory(@Valid @RequestBody ReqCreateCategory req){
        Category category = categoryMapper.reqCreateToEntity(req);

        categoryService.createCategory(category);

        ResCreateCategory res = categoryMapper.entityToResCreate(category);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResCategory> findCategoryById(@PathVariable("id") int id){
        Category category = categoryService.findCategoryById(id);
        if(category != null){
            return ResponseEntity.ok(categoryMapper.entityToRes(category));
        }
        return null;
    }

    @GetMapping("")
    public ResponseEntity<List<ResCategory>> findAllCategory(){
        List<ResCategory> res = new ArrayList<>();
        List<Category> categories = categoryService.findAllCategory();

        for(Category category : categories){
            res.add(categoryMapper.entityToRes(category));
        }

        return ResponseEntity.ok(res);
    }

    @PutMapping("")
    public ResponseEntity<ResUpdateCategory> updateCategory(@Valid @RequestBody ReqUpdateCategory req){
        Category category = categoryService.findCategoryById(req.getId());
        if(category != null){
            Category res = categoryMapper.reqUpdateToEntity(req);
            categoryService.updateCategory(res);
            return ResponseEntity.ok(categoryMapper.entityToResUpdate(res));
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
