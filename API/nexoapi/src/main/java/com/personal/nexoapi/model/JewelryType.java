package com.personal.nexoapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Jewelry_Type",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_name", columnNames = {"name"}),
        @UniqueConstraint(name = "uq_code", columnNames = {"code"})
        })

public class JewelryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
