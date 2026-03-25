package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.personal.nexoapi.model.DetailType;

import java.util.Optional;
import java.util.List;

public interface DetailTypeRepository extends JpaRepository<DetailType, Long>{
    Optional<DetailType> findByName (String name);
    Optional<DetailType> findByCode (String code);
    List<DetailType> findByDesignType (Long DesignId);
}
