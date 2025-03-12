package com.ktn3.computer_shop.repo;

import com.ktn3.computer_shop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findByProductId(int productId);
}
