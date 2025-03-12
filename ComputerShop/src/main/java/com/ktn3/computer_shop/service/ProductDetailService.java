package com.ktn3.computer_shop.service;

import com.ktn3.computer_shop.entity.ProductDetail;
import com.ktn3.computer_shop.repo.ProductDetailRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductDetailService {
    @Autowired
    ProductDetailRepo productDetailRepo;

    public ProductDetail createProductDetail(ProductDetail req){
        return productDetailRepo.save(req);
    }

    public ProductDetail findProductDetailById(int id){
        return productDetailRepo.findById(id).orElse(null);
    }

    public List<ProductDetail> findAllProductDetail(){
        return productDetailRepo.findAll();
    }

    public ProductDetail updateProductDetail(ProductDetail req){
        ProductDetail productDetail = findProductDetailById(req.getId());

        productDetail.setColor(req.getColor());
        productDetail.setManufacturer(req.getManufacturer());
        productDetail.setOrigin(req.getOrigin());
        productDetail.setWarrantyPeriod(req.getWarrantyPeriod());
        productDetail.setWarranty(req.getWarranty());
        productDetail.setCpuType(req.getCpuType());
        productDetail.setCpuSpeed(req.getCpuSpeed());
        productDetail.setCache(req.getCache());
        productDetail.setRamCapacity(req.getRamCapacity());
        productDetail.setDisk(req.getDisk());
        productDetail.setCapacity(req.getCapacity());
        productDetail.setVga(req.getVga());
        productDetail.setPort(req.getPort());
        productDetail.setWifi(req.isWifi());
        productDetail.setOs(req.getOs());
        productDetail.setDescription(req.getDescription());
        productDetail.setPrice(req.getPrice());

        return productDetailRepo.save(productDetail);
    }

    public void deleteProductDetail(int id){
        ProductDetail productDetail = findProductDetailById(id);
        if(productDetail != null){
            productDetailRepo.deleteById(id);
        }
    }

    public ProductDetail findByProductId(int productId){
        return productDetailRepo.findByProductId(productId).orElse(null);
    }
}
