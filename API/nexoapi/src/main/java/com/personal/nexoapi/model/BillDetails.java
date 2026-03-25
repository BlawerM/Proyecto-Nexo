package com.personal.nexoapi.model;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Bill_Details")
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(
        name = "id_bill", nullable = false,
        foreignKey = @ForeignKey(name = "fk_billDetail_bill",
        foreignKeyDefinition = "FOREIGN KEY (id_bill) REFERENCES Bill(id)"))
    Bill Bill;

    @JoinColumn(
        name = "id_product", nullable = false,
        foreignKey = @ForeignKey(name = "fk_billDetail_product",
        foreignKeyDefinition = "FOREIGN KEY (id_product) REFERENCES Product(id)"))
    Product product;

    @Column(name = "product_SKU", length = 20)
    String SKU;

    @Column(nullable = false)
    int cuantity;

    @Column(name = "unit_price", precision = 12, scale = 2, nullable = false)
    BigDecimal unitPrice;

    @Column(name = "subtotal", precision = 12, scale = 2, nullable = false)
    BigDecimal subtotal;

}
