package com.personal.nexoapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Detail_Type",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_name", columnNames = {"name"}),
        @UniqueConstraint(name = "uq_code", columnNames = {"code"})
        })

public class DetailType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(
        name = "id_design", nullable = false,
        foreignKey = @ForeignKey(name = "fk_detail_design",
        foreignKeyDefinition = "FOREIGN KEY (id_design) REFERENCES Design_Type(id) ON DELETE CASCADE"))
        private DesignType designType;

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

    public DesignType getDesignType() {
        return designType;
    }

    public void setDesignType(DesignType designType) {
        this.designType = designType;
    }

}
