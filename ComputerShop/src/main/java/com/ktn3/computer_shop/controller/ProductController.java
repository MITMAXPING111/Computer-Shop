package com.ktn3.computer_shop.controller;

import com.ktn3.computer_shop.dto.request.category.ReqIdCategory;
import com.ktn3.computer_shop.dto.request.product.ReqCreateProduct;
import com.ktn3.computer_shop.dto.request.product.ReqIdProduct;
import com.ktn3.computer_shop.dto.request.product.ReqUpdateProduct;
import com.ktn3.computer_shop.dto.request.product_detail.ReqCreateProductDetail;
import com.ktn3.computer_shop.dto.request.product_image.ReqCreateProductImage;
import com.ktn3.computer_shop.dto.response.product.ResCreateProduct;
import com.ktn3.computer_shop.dto.response.product.ResProduct;
import com.ktn3.computer_shop.dto.response.product.ResUpdateProduct;
import com.ktn3.computer_shop.entity.Category;
import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.entity.ProductDetail;
import com.ktn3.computer_shop.entity.ProductImage;
import com.ktn3.computer_shop.mapper.CategoryMapper;
import com.ktn3.computer_shop.mapper.ProductDetailMapper;
import com.ktn3.computer_shop.mapper.ProductImageMapper;
import com.ktn3.computer_shop.mapper.ProductMapper;
import com.ktn3.computer_shop.service.CategoryService;
import com.ktn3.computer_shop.service.ProductDetailService;
import com.ktn3.computer_shop.service.ProductImageService;
import com.ktn3.computer_shop.service.ProductService;
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
@RequestMapping("/api/v1/san-pham")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductImageMapper productImageMapper;

    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductDetailMapper productDetailMapper;

    @PostMapping("")
    public ResponseEntity<List<ResCreateProduct>> createProduct (@Valid @RequestBody List<ReqCreateProduct> listReq){
        ReqIdCategory idCategory = listReq.get(0).getCategory();
        Category category = categoryService.findCategoryById(idCategory.getId());

        if(category != null){
            List<ResCreateProduct> listRes = new ArrayList<>();
            for(ReqCreateProduct req : listReq){
                Product product = productMapper.reqCreateToEntity(req);
                productService.createProduct(product);
                ResCreateProduct res = productMapper.entityToResCreate(product);
                listRes.add(res);

                if(req.getProductDetail() != null){
                    ReqCreateProductDetail detailReq = req.getProductDetail();
                    ReqIdProduct idProduct = new ReqIdProduct(product.getId());
                    detailReq.setProduct(idProduct);
                    ProductDetail detail = productDetailMapper.reqCreateToEntity(detailReq);

                    productDetailService.createProductDetail(detail);
                }

                if (req.getProductImages() != null && !req.getProductImages().isEmpty()) {
                    for (ReqCreateProductImage imgReq : req.getProductImages()) {
                        ReqIdProduct idProduct = new ReqIdProduct(product.getId());
                        imgReq.setProduct(idProduct);
                        ProductImage image = productImageMapper.reqCreateToEntity(imgReq);

                        productImageService.createProductImage(image);
                    }
                }
            }

            return ResponseEntity.ok(listRes);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResProduct> findProduct(@PathVariable("id") int id){
        Product product = productService.findProductById(id);
        ResProduct res = new ResProduct();
        if(product != null) {
            res = productMapper.entityToRes(product);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping("")
    public ResponseEntity<List<ResProduct>> findAllProduct(){
        List<ResProduct> res = new ArrayList<>();
        List<Product> products = productService.findAllProduct();

        for(Product product : products)
            res.add(productMapper.entityToRes(product));

        return ResponseEntity.ok(res);
    }

//    @PutMapping("")
//    public ResponseEntity<ResUpdateProduct> updateProduct(@Valid @RequestBody ReqUpdateProduct req){
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
