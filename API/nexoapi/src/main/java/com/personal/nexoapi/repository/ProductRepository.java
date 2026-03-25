package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.nexoapi.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findBySKU(String SKU);
    List<Product> findByDetailType_ID(Long idDetail);
    List<Product> findByDetailType_DesignType_ID(Long idDesign);
    List<Product> findByJewelryType_ID(Long idJewelry);
    List<Product> findByPrice(BigDecimal min, BigDecimal max);
}
