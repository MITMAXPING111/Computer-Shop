package com.ktn3.computer_shop.dto.response.category;

import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ResCategory {
    int id;
    String name;
    String description;
    ResIdCategory parentCategory;
    List<ResIdCategory> subCategories;
    List<ResIdProduct> products;
}
