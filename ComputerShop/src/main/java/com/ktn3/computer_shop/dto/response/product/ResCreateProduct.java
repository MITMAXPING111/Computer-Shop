package com.ktn3.computer_shop.dto.response.product;

import com.ktn3.computer_shop.dto.response.category.ResIdCategory;
import com.ktn3.computer_shop.dto.response.product_detail.ResCreateProductDetail;
import com.ktn3.computer_shop.dto.response.product_image.ResCreateProductImage;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResCreateProduct {
    ResIdCategory category;

    int id;
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    String name;
    String model;
    @NotBlank(message = "CPU không được để trống!")
    String cpu;
    @NotBlank(message = "RAM không được để trống!")
    String ram;
    boolean active;
}
