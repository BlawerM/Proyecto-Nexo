package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.nexoapi.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findBySKU(String SKU);
    List<Product> findByDetail(Long idDetail);
    List<Product> findByDesign(Long idDesign);
    List<Product> findByJewelry(Long idJewelry);
    List<Product> findByBill (Long BillDetails);
    List<Product> findByPriceRange(BigDecimal min, BigDecimal max);
}
