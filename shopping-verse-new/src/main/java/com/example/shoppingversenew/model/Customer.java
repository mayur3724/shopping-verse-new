package com.example.shoppingversenew.model;

import com.example.shoppingversenew.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true)
    String mailId;
    @Column(unique = true)
    String mobNo;
    Gender gender;

    @OneToOne(mappedBy = "customer", cascade=CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Card> cards = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();

}
