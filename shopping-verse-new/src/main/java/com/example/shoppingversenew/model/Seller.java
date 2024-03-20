package com.example.shoppingversenew.model;

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
@Table(name="seller")

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true, nullable = false)
    String panNo;
    @Column(unique = true, nullable = false)
    String mailId;
   //by writing nullable equals to false, we can make pan and mail as foreign key also,
   // if not written then id is the only option left
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List< Product> products = new ArrayList<>();
}
