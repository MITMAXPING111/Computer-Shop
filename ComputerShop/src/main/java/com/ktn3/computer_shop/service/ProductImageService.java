package com.ktn3.computer_shop.service;

import com.ktn3.computer_shop.entity.ProductImage;
import com.ktn3.computer_shop.repo.ProductImageRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductImageService {
    @Autowired
    ProductImageRepo productImageRepo;

    public ProductImage createProductImage(ProductImage req){
        return productImageRepo.save(req);
    }

    public ProductImage findProductImageById(int id){
        return productImageRepo.findById(id).orElse(null);
    }

    public List<ProductImage> findAllProductImage(){
        return productImageRepo.findAll();
    }

    public ProductImage updateProductImage(ProductImage req){
        ProductImage productImage = findProductImageById(req.getId());

        productImage.setImageUrl(req.getImageUrl());
        productImage.setPrimary(req.isPrimary());

        return productImageRepo.save(productImage);
    }

    public void deleteProductImage(int id){
        ProductImage productImage = findProductImageById(id);
        if(productImage != null){
            productImageRepo.deleteById(id);
        }
    }

    public List<ProductImage> findByProductId(int productId){
        return productImageRepo.findByProductId(productId);
    }
}
