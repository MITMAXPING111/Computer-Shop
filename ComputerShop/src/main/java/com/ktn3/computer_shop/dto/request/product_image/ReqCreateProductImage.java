package com.ktn3.computer_shop.dto.request.product_image;

import com.ktn3.computer_shop.dto.request.product.ReqIdProduct;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqCreateProductImage {
    ReqIdProduct product;
    @NotBlank(message = "URL image không được để trống!")
    String imageUrl;
    boolean isPrimary;
}
