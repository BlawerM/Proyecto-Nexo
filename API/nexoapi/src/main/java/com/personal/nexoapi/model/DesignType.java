package com.personal.nexoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Design_Type")
public class DesignType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

}
