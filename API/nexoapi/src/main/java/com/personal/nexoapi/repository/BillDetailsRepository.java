package com.personal.nexoapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.personal.nexoapi.model.BillDetails;

import java.util.List;
import java.util.Optional;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long>{
    List<BillDetails> findByBill_ID (Long bill);
}
