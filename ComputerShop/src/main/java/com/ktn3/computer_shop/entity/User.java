package com.ktn3.computer_shop.entity;

import com.ktn3.computer_shop.util.constant.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank(message = "Username không được để trống!")
    @Column(unique = true, nullable = false)
    String username;
    @NotBlank(message = "Password không được để trống!")
    String password;
    @NotBlank(message = "Email không được để trống!")
    String email;
    Role role;
    String fullName;
    String phone;

    String province; // tỉnh
    String district; // huyện
    String ward; // xã

    @Column(columnDefinition = "TEXT")
    String address;

    Instant createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    Staff staff;
}
