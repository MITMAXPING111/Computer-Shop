package com.ktn3.computer_shop.service;

import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.entity.ProductDetail;
import com.ktn3.computer_shop.entity.ProductImage;
import com.ktn3.computer_shop.repo.ProductRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product createProduct(Product req){
        return productRepo.save(req);
    }

    public Product findProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product req){
        Product product = findProductById(req.getId());

        product.setName(req.getName());
        product.setModel(req.getModel());
        product.setCpu(req.getCpu());
        product.setRam(req.getRam());
        product.setCategory(req.getCategory());

        return productRepo.save(product);
    }

    public String deleteProduct(int id){
        Product product = findProductById(id);
        if(product != null){
            productRepo.deleteById(id);
            return "Đã xóa sản phẩm " + product.getName();
        }
        return "Không tồn tại sản phẩm!";
    }
}
