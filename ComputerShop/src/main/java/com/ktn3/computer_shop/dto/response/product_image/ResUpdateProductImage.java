package com.ktn3.computer_shop.dto.response.product_image;

import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResUpdateProductImage {
    ResIdProduct product;
    int id;
    String imageUrl;
    boolean isPrimary;
}
