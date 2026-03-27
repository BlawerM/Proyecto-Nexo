package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.personal.nexoapi.model.Bill;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long>{
    
}
