package com.personal.nexoapi.model;
import java.math.BigDecimal;
import java.time.*;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @CreationTimestamp
    @Column(name = "issue_date")
    OffsetDateTime issueDate;

    @Column(name = "price", precision = 12, scale = 2, nullable = false)
    BigDecimal total;
}
