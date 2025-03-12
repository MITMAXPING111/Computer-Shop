package com.ktn3.computer_shop.dto.request.product;

import com.ktn3.computer_shop.dto.request.category.ReqIdCategory;
import com.ktn3.computer_shop.dto.request.product_detail.ReqIdProductDetail;
import com.ktn3.computer_shop.dto.request.product_image.ReqIdProductImage;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqUpdateProduct {
    ReqIdCategory category;

    int id;
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    String name;
    String model;
    @NotBlank(message = "CPU không được để trống!")
    String cpu;
    @NotBlank(message = "RAM không được để trống!")
    String ram;

    ReqIdProductDetail productDetail;
    List<ReqIdProductImage> productImages;
}
