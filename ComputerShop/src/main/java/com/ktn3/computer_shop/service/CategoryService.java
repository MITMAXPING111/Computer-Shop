package com.ktn3.computer_shop.service;

import com.ktn3.computer_shop.entity.Category;
import com.ktn3.computer_shop.repo.CategoryRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public Category createCategory(Category req){
        return categoryRepo.save(req);
    }

    public Category findCategoryById(int id){
        return categoryRepo.findById(id).orElse(null);
    }

    public List<Category> findAllCategory(){
        return categoryRepo.findAll();
    }

    public Category updateCategory(Category req){
        Category category = findCategoryById(req.getId());

        category.setName(req.getName());
        category.setDescription(req.getDescription());
        category.setParentCategory(req.getParentCategory());

        return categoryRepo.save(category);
    }

    public String deleteCategory(int id){
        Category category = findCategoryById(id);
        if(category != null){
            categoryRepo.deleteById(id);
            return "Đã xóa danh mục " + category.getName();
        }
        return "Không tồn tại danh mục!";
    }
}
