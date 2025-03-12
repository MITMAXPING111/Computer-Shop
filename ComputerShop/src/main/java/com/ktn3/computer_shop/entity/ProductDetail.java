package com.ktn3.computer_shop.entity;

import com.ktn3.computer_shop.util.constant.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(columnDefinition = "TEXT")
    String description;
    float price;

    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;
}
