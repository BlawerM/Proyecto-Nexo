package com.personal.nexoapi.service;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.Bill;
import com.personal.nexoapi.repository.BillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill (Bill bill){
        return billRepository.save(bill);
    }

    public List<Bill> findAll (){
        return billRepository.findAll();
    }
    public Optional<Bill> findById (Long id){
        return billRepository.findById(id);
    }
}
