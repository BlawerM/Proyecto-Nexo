package com.personal.nexoapi.model;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Product",
    uniqueConstraints = {
        @UniqueConstraint(name ="uq_SKU", columnNames = {"SKU"})
    })

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_jewelry", nullable = false,
        foreignKey = @ForeignKey(name = "fk_product_jewelry",
        foreignKeyDefinition = "FOREIGN KEY (id_jewelry) REFERENCES Jewelry_Type(id)"))
    JewelryType jewelryType;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_detail", nullable = false,
        foreignKey = @ForeignKey(name = "fk_product_detail",
        foreignKeyDefinition = "FOREIGN KEY (id_detail) REFERENCES Detail_Type(id)"))
    DetailType detailType;

    @Column(length = 150)
    String description;

    @Column(nullable = false)
    int stock;

    @Column(name = "price", precision = 12, scale = 2, nullable = false)
    BigDecimal price;


    @Column(length = 20)
    String SKU;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public JewelryType getJewelryType() {
		return jewelryType;
	}

	public void setJewelryType(JewelryType jewelryType) {
		this.jewelryType = jewelryType;
	}

	public DetailType getDetailType() {
		return detailType;
	}

	public void setDetailType(DetailType detailType) {
		this.detailType = detailType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}
}
