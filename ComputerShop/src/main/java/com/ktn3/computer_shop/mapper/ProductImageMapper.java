package com.ktn3.computer_shop.mapper;

import com.ktn3.computer_shop.dto.request.product.ReqIdProduct;
import com.ktn3.computer_shop.dto.request.product_image.ReqCreateProductImage;
import com.ktn3.computer_shop.dto.request.product_image.ReqUpdateProductImage;
import com.ktn3.computer_shop.dto.response.product.ResCreateProduct;
import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import com.ktn3.computer_shop.dto.response.product_image.ResCreateProductImage;
import com.ktn3.computer_shop.dto.response.product_image.ResUpdateProductImage;
import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.entity.ProductImage;
import com.ktn3.computer_shop.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class ProductImageMapper {
    @Autowired
    ProductService productService;

    public ProductImage reqCreateToEntity(ReqCreateProductImage req){
        ProductImage productImage = new ProductImage();
        ReqIdProduct idProduct = req.getProduct();
        Product product = productService.findProductById(idProduct.getId());

        if(product != null){
            productImage.setImageUrl(req.getImageUrl());
            productImage.setPrimary(req.isPrimary());
            productImage.setProduct(product);
        }

        return productImage;
    }

    public ResCreateProductImage entityToResCreate(ProductImage productImage){
        ResCreateProductImage res = new ResCreateProductImage();
        Product product = productImage.getProduct();
        ResIdProduct idProduct = new ResIdProduct();

        if(product != null){
            idProduct.setId(product.getId());
            res.setProduct(idProduct);

            res.setId(productImage.getId());
            res.setImageUrl(productImage.getImageUrl());
            res.setPrimary(productImage.isPrimary());
        }

        return res;
    }

    public ProductImage reqUpdateToEntity(ReqUpdateProductImage req){
        ProductImage productImage = new ProductImage();
        ReqIdProduct idProduct = req.getProduct();
        Product product = productService.findProductById(idProduct.getId());

        if(product != null){
            productImage.setId(req.getId());
            productImage.setImageUrl(req.getImageUrl());
            productImage.setPrimary(req.isPrimary());
            productImage.setProduct(product);
        }

        return productImage;
    }

    public ResUpdateProductImage entityToResUpdate(ProductImage productImage){
        ResUpdateProductImage res = new ResUpdateProductImage();
        Product product = productImage.getProduct();
        ResIdProduct idProduct = new ResIdProduct();

        if(product != null){
            idProduct.setId(product.getId());
            res.setProduct(idProduct);

            res.setId(productImage.getId());
            res.setImageUrl(productImage.getImageUrl());
            res.setPrimary(productImage.isPrimary());
        }

        return res;
    }
}
