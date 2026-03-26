package com.personal.nexoapi.model;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "Bill_Details")
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_bill", nullable = false,
        foreignKey = @ForeignKey(name = "fk_billDetail_bill",
        foreignKeyDefinition = "FOREIGN KEY (id_bill) REFERENCES Bill(id)"))
    Bill bill;

    @ManyToOne(optional = false)
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

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

}
