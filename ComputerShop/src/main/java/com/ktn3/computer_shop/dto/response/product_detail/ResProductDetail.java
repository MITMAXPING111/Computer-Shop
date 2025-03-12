package com.ktn3.computer_shop.dto.response.product_detail;

import com.ktn3.computer_shop.dto.response.product.ResIdProduct;
import com.ktn3.computer_shop.util.constant.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ResProductDetail {
    ResIdProduct product;
    int id;
    String color;
    Manufacturer manufacturer;
    String origin;
    int warrantyPeriod;
    Warranty warranty;
    String cpuType;
    Float cpuSpeed;
    String cache;
    int ramCapacity;
    Disk disk;
    Capacity capacity;
    String vga;
    Port port;
    boolean wifi;
    OS os;
    String description;
    float price;
}
