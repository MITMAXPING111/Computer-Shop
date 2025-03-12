package com.ktn3.computer_shop.mapper;

import com.ktn3.computer_shop.dto.request.category.ReqCreateCategory;
import com.ktn3.computer_shop.dto.request.category.ReqIdCategory;
import com.ktn3.computer_shop.dto.request.category.ReqUpdateCategory;
import com.ktn3.computer_shop.dto.response.category.ResCategory;
import com.ktn3.computer_shop.dto.response.category.ResCreateCategory;
import com.ktn3.computer_shop.dto.response.category.ResIdCategory;
import com.ktn3.computer_shop.dto.response.category.ResUpdateCategory;
import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import com.ktn3.computer_shop.entity.Category;
import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.service.CategoryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class CategoryMapper {
    @Autowired
    CategoryService categoryService;

    public Category reqCreateToEntity(ReqCreateCategory req){
        Category res = new Category();
        ReqIdCategory category = req.getParentCategory();

        res.setName(req.getName());
        res.setDescription(req.getDescription());
        if(category != null)
            res.setParentCategory(categoryService.findCategoryById(category.getId()));

        return res;
    }

    public Category reqUpdateToEntity(ReqUpdateCategory req){
        Category res = new Category();

        res.setId(req.getId());
        res.setName(req.getName());
        res.setDescription(req.getDescription());

        if(req.getParentCategory() != null){
            Category category = categoryService.findCategoryById(req.getParentCategory().getId());
            if(category != null && req.getId() != category.getId())
                res.setParentCategory(category);
        }

        return res;
    }

    public ResCreateCategory entityToResCreate(Category category){
        ResCreateCategory res = new ResCreateCategory();
        ResIdCategory parentCategory = new ResIdCategory();

        res.setId(category.getId());
        res.setName(category.getName());
        res.setDescription(category.getDescription());

        if(category.getParentCategory() != null){
            parentCategory.setId(category.getParentCategory().getId());
            res.setParentCategory(parentCategory);
        }

        return res;
    }

    public ResUpdateCategory entityToResUpdate(Category category){
        ResUpdateCategory res = new ResUpdateCategory();
        ResIdCategory parentCategory = new ResIdCategory();

        res.setId(category.getId());
        res.setName(category.getName());
        res.setDescription(category.getDescription());

        if(category.getParentCategory() != null){
            parentCategory.setId(category.getParentCategory().getId());
            res.setParentCategory(parentCategory);
        }

        return res;
    }

    public ResCategory entityToRes(Category category){
        ResCategory res = new ResCategory();
        Category category1 = category.getParentCategory();
        ResIdCategory idCategory = new ResIdCategory();
        List<Category> categories = category.getSubCategories();
        List<ResIdCategory> idCategories = new ArrayList<>();
        List<Product> products = category.getProducts();
        List<ResIdProduct> idProducts = new ArrayList<>();

        if(category1 != null)
            idCategory.setId(category1.getId());

        for(Category category2 : categories){
            ResIdCategory idCategory1 = new ResIdCategory();

            idCategory1.setId(category2.getId());

            idCategories.add(idCategory1);
        }

        for(Product product : products){
            ResIdProduct idProduct = new ResIdProduct();

            idProduct.setId(product.getId());

            idProducts.add(idProduct);
        }

        res.setId(category.getId());
        res.setName(category.getName());
        res.setDescription(category.getDescription());
        if(idCategory.getId() > 0)
            res.setParentCategory(idCategory);
        res.setSubCategories(idCategories);
        res.setProducts(idProducts);

        return res;
    }
}
