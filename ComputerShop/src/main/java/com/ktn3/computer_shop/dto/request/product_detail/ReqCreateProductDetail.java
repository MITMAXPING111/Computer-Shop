package com.ktn3.computer_shop.dto.request.product_detail;

import com.ktn3.computer_shop.dto.request.product.ReqIdProduct;
import com.ktn3.computer_shop.util.constant.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqCreateProductDetail {
    ReqIdProduct product;
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
