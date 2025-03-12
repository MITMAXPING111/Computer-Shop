package com.ktn3.computer_shop.dto.request.product;

import com.ktn3.computer_shop.dto.request.category.ReqIdCategory;
import com.ktn3.computer_shop.dto.request.product_detail.ReqCreateProductDetail;
import com.ktn3.computer_shop.dto.request.product_image.ReqCreateProductImage;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqCreateProduct {
    ReqIdCategory category;

    @NotBlank(message = "Tên sản phẩm không được để trống!")
    String name;
    String model;
    @NotBlank(message = "CPU không được để trống!")
    String cpu;
    @NotBlank(message = "RAM không được để trống!")
    String ram;

    ReqCreateProductDetail productDetail;
    List<ReqCreateProductImage> productImages;
}
