package com.ktn3.computer_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Table(name = "staff_info_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Instant startDate;
    Instant endDate;
    String department;
    String position;
    Float salary;
    boolean active;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staff;
}
