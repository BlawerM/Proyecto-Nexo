package com.personal.nexoapi.model;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_jewelry", nullable = false,
        foreignKey = @ForeignKey(name = "fk_product_design",
        foreignKeyDefinition = "FOREIGN KEY (id_jewelry) REFERENCES Jewelry_Type(id)"))
    JewelryType jewelryType;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_detail", nullable = false,
        foreignKey = @ForeignKey(name = "fk_product_detail",
        foreignKeyDefinition = "FOREIGN KEY (id_detail) REFERENCES Detail_Type(id)"))
    DetailType detailType;

    @Column(length = 150)
    String Description;

    @Column(nullable = false)
    int stock;

    @Column(name = "price", precision = 12, scale = 2, nullable = false)
    BigDecimal price;


    @Column(length = 20)
    String SKU;

}
