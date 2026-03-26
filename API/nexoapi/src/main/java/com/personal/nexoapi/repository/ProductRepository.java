package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.nexoapi.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findBySKU(String SKU);
    List<Product> findByDetailType_ID(Long idDetail);
        //JPA reads the name as: findBy, tablename, secondtablename, column value
        //this works different because there's no direct connection between product and designType
    List<Product> findByDetailType_DesignType_ID(Long idDesign);
    List<Product> findByJewelryType_ID(Long idJewelry);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
