package com.personal.nexoapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Detail_Type")
public class DetailType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_design", nullable = false,
        foreignKey = @ForeignKey(name = "fk_detail_design",
        foreignKeyDefinition = "FOREIGN KEY (id_design) REFERENCES Design_Type(id) ON DELETE CASCADE"))
        private DesignType designType;
}
