package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.personal.nexoapi.model.DesignType;
import java.util.Optional;

public interface DesignTypeRepository extends JpaRepository<DesignType, Long> {
    Optional<DesignType> findByName (String name);
    Optional<DesignType> findByCode (String code);
}
