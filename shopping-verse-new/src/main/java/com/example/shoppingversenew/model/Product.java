package com.example.shoppingversenew.model;

import com.example.shoppingversenew.Enum.ProductCategory;
import com.example.shoppingversenew.Enum.ProductStatus;
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
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int availableQuantity;

    String productName;

    int price;

    ProductCategory category;

    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Item> items =new ArrayList<>();
}
