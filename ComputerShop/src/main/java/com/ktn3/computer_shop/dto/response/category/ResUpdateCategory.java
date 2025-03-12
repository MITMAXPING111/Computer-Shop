package com.ktn3.computer_shop.dto.response.category;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResUpdateCategory {
    int id;
    String name;
    String description;
    ResIdCategory parentCategory;
}
