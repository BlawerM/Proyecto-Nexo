package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.personal.nexoapi.model.JewelryType;
import java.util.Optional;

public interface JewelryTypeRepository extends JpaRepository <JewelryType, Long> {
    Optional<JewelryType> findByName (String name);
    Optional<JewelryType> findByCode (String code);

}
