package com.ktn3.computer_shop.mapper;

import com.ktn3.computer_shop.dto.request.product.ReqIdProduct;
import com.ktn3.computer_shop.dto.request.product_detail.ReqCreateProductDetail;
import com.ktn3.computer_shop.dto.request.product_detail.ReqUpdateProductDetail;
import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import com.ktn3.computer_shop.dto.response.product_detail.ResCreateProductDetail;
import com.ktn3.computer_shop.dto.response.product_detail.ResIdProductDetail;
import com.ktn3.computer_shop.dto.response.product_detail.ResUpdateProductDetail;
import com.ktn3.computer_shop.entity.Product;
import com.ktn3.computer_shop.entity.ProductDetail;
import com.ktn3.computer_shop.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class ProductDetailMapper {
    @Autowired
    ProductService productService;

    public ProductDetail reqCreateToEntity(ReqCreateProductDetail req){
        ProductDetail productDetail = new ProductDetail();
        ReqIdProduct idProduct = req.getProduct();
        Product product = productService.findProductById(idProduct.getId());

        if(product != null){
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
            productDetail.setProduct(product);
        }

        return productDetail;
    }

    public ResCreateProductDetail entityToResCreate(ProductDetail productDetail){
        ResCreateProductDetail res = new ResCreateProductDetail();
        Product product = productDetail.getProduct();
        ResIdProduct idProduct = new ResIdProduct();

        if(product != null){
            idProduct.setId(product.getId());
            res.setProduct(idProduct);

            res.setId(productDetail.getId());
            res.setColor(productDetail.getColor());
            res.setManufacturer(productDetail.getManufacturer());
            res.setOrigin(productDetail.getOrigin());
            res.setWarrantyPeriod(productDetail.getWarrantyPeriod());
            res.setWarranty(productDetail.getWarranty());
            res.setCpuType(productDetail.getCpuType());
            res.setCpuSpeed(productDetail.getCpuSpeed());
            res.setCache(productDetail.getCache());
            res.setRamCapacity(productDetail.getRamCapacity());
            res.setDisk(productDetail.getDisk());
            res.setCapacity(productDetail.getCapacity());
            res.setVga(productDetail.getVga());
            res.setPort(productDetail.getPort());
            res.setWifi(productDetail.isWifi());
            res.setOs(productDetail.getOs());
            res.setDescription(productDetail.getDescription());
            res.setPrice(productDetail.getPrice());
        }

        return res;
    }

    public ProductDetail reqUpdateToEntity(ReqUpdateProductDetail req){
        ProductDetail productDetail = new ProductDetail();
        ReqIdProduct idProduct = req.getProduct();
        Product product = productService.findProductById(idProduct.getId());

        if(product != null){
            productDetail.setId(req.getId());
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
            productDetail.setProduct(product);
        }

        return productDetail;
    }

    public ResUpdateProductDetail entityToResUpdate(ProductDetail productDetail){
        Product product = productDetail.getProduct();

        if(product != null){
            ResIdProduct idProduct = new ResIdProduct(product.getId());
            ResUpdateProductDetail res = new ResUpdateProductDetail();

            res.setProduct(idProduct);
            res.setId(productDetail.getId());
            res.setColor(productDetail.getColor());
            res.setManufacturer(productDetail.getManufacturer());
            res.setOrigin(productDetail.getOrigin());
            res.setWarrantyPeriod(productDetail.getWarrantyPeriod());
            res.setWarranty(productDetail.getWarranty());
            res.setCpuType(productDetail.getCpuType());
            res.setCpuSpeed(productDetail.getCpuSpeed());
            res.setCache(productDetail.getCache());
            res.setRamCapacity(productDetail.getRamCapacity());
            res.setDisk(productDetail.getDisk());
            res.setCapacity(productDetail.getCapacity());
            res.setVga(productDetail.getVga());
            res.setPort(productDetail.getPort());
            res.setWifi(productDetail.isWifi());
            res.setOs(productDetail.getOs());
            res.setDescription(productDetail.getDescription());
            res.setPrice(productDetail.getPrice());

            return res;
        }

        return null;
    }

}
