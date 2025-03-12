package com.ktn3.computer_shop.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqCreateCategory {
    @NotBlank(message = "Tên danh mục không được để trống!")
    String name;
    String description;
    ReqIdCategory parentCategory;
}
