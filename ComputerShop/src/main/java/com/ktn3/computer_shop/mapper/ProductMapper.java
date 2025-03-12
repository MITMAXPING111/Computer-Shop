package com.ktn3.computer_shop.mapper;

import com.ktn3.computer_shop.dto.request.category.ReqIdCategory;
import com.ktn3.computer_shop.dto.request.product.ReqCreateProduct;
import com.ktn3.computer_shop.dto.response.category.ResIdCategory;
import com.ktn3.computer_shop.dto.response.product.ResProduct;
import com.ktn3.computer_shop.dto.response.product.ResCreateProduct;
import com.ktn3.computer_shop.dto.response.product_detail.ResIdProductDetail;
import com.ktn3.computer_shop.dto.response.product_image.ResIdProductImage;
import com.ktn3.computer_shop.entity.Category;
import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.entity.ProductDetail;
import com.ktn3.computer_shop.entity.ProductImage;
import com.ktn3.computer_shop.service.CategoryService;
import com.ktn3.computer_shop.service.ProductDetailService;
import com.ktn3.computer_shop.service.ProductImageService;
import com.ktn3.computer_shop.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class ProductMapper {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductDetailMapper productDetailMapper;
    @Autowired
    ProductImageMapper productImageMapper;


    public Product reqCreateToEntity(ReqCreateProduct req){
        Product res = new Product();
        ReqIdCategory idCategory = req.getCategory();
        Category category = categoryService.findCategoryById(idCategory.getId());

        if(category != null){
            res.setCategory(category);
            res.setName(req.getName());
            res.setModel(req.getModel());
            res.setCpu(req.getCpu());
            res.setRam(req.getRam());
            res.setActive(true);
        }

        return res;
    }

//    public Product reqUpdateToEntity(ReqUpdateProduct req){
//        Product res = new Product();
//
//        res.setId(req.getId());
//        res.setName(req.getName());
//        res.setDescription(req.getDescription());
//
//        if(req.getParentProduct() != null){
//            Product product = productService.findProductById(req.getParentProduct().getId());
//            if(product != null && req.getId() != product.getId())
//                res.setParentProduct(product);
//        }
//
//        return res;
//    }

    public ResCreateProduct entityToResCreate(Product product){
        ResCreateProduct res = new ResCreateProduct();

        Category category = product.getCategory();
        ResIdCategory idCategory = new ResIdCategory();
        idCategory.setId(category.getId());

        res.setCategory(idCategory);
        res.setId(product.getId());
        res.setName(product.getName());
        res.setModel(product.getModel());
        res.setCpu(product.getCpu());
        res.setRam(product.getRam());
        res.setActive(product.isActive());

        return res;
    }

//    public ResUpdateProduct entityToResUpdate(Product product){
//        ResUpdateProduct res = new ResUpdateProduct();
//        ResIdProduct parentProduct = new ResIdProduct();
//
//        res.setId(product.getId());
//        res.setName(product.getName());
//        res.setDescription(product.getDescription());
//
//        if(product.getParentProduct() != null){
//            parentProduct.setId(product.getParentProduct().getId());
//            res.setParentProduct(parentProduct);
//        }
//
//        return res;
//    }
//
//    public ResProduct entityToRes(Product product){
//        ResProduct res = new ResProduct();
//        Product product1 = product.getParentProduct();
//        ResIdProduct idProduct = new ResIdProduct();
//        List<Product> categories = product.getSubCategories();
//        List<ResIdProduct> idCategories = new ArrayList<>();
//        List<Product> products = product.getProducts();
//        List<ResIdProduct> idProducts = new ArrayList<>();
//
//        if(product1 != null)
//            idProduct.setId(product1.getId());
//
//        for(Product product2 : categories){
//            ResIdProduct idProduct1 = new ResIdProduct();
//
//            idProduct1.setId(product2.getId());
//
//            idCategories.add(idProduct1);
//        }
//
//        for(Product product : products){
//            ResIdProduct idProduct = new ResIdProduct();
//
//            idProduct.setId(product.getId());
//
//            idProducts.add(idProduct);
//        }
//
//        res.setId(product.getId());
//        res.setName(product.getName());
//        res.setDescription(product.getDescription());
//        if(idProduct.getId() > 0)
//            res.setParentProduct(idProduct);
//        res.setSubCategories(idCategories);
//        res.setProducts(idProducts);
//
//        return res;
//    }

    public ResProduct entityToRes(Product product){
        ResProduct res = new ResProduct();
        Category category = product.getCategory();

        if(category != null){
            ResIdCategory idCategory = new ResIdCategory();
            idCategory.setId(category.getId());
            res.setCategory(idCategory);

            res.setId(product.getId());
            res.setName(product.getName());
            res.setModel(product.getModel());
            res.setCpu(product.getCpu());
            res.setRam(product.getRam());
            res.setActive(product.isActive());

            ProductDetail productDetail = product.getProductDetail();
            ResIdProductDetail idProductDetail = new ResIdProductDetail();
            if(productDetail != null){
                idProductDetail.setId(productDetail.getId());
                res.setProductDetail(idProductDetail);
            }

            List<ProductImage> productImages = product.getImages();
            List<ResIdProductImage> images = new ArrayList<>();
            if(!productImages.isEmpty()){
                for(ProductImage productImage : productImages){
                    ResIdProductImage image = new ResIdProductImage();
                    image.setId(productImage.getId());
                    images.add(image);
                }
                res.setProductImages(images);
            }
        }

        return res;
    }
}
