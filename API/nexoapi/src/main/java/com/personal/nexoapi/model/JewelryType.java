package com.personal.nexoapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Jewelry_Type")
public class JewelryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;
}
