package com.personal.nexoapi.service;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.BillDetails;
import com.personal.nexoapi.repository.BillDetailsRepository;
import com.personal.nexoapi.model.Bill;
import com.personal.nexoapi.repository.BillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BillDetailsService {
    BillRepository billRepository;
    BillDetailsRepository billDetailsRepository;

    public BillDetailsService(BillRepository billRepository, BillDetailsRepository billDetailsRepository) {
        this.billRepository = billRepository;
        this.billDetailsRepository = billDetailsRepository;
    }

    public BillDetails createBillDetails (Long billId, BillDetails billDetails){
        Bill bill = billRepository.findById(billId)
        .orElseThrow(() -> new RuntimeException("Esta factura no existe"));

        billDetails.setBill(bill);
        return billDetailsRepository.save(billDetails);
    }

    public List<BillDetails> findAll(){
        return billDetailsRepository.findAll();
    }

    public Optional<BillDetails> findById (Long id){
        return billDetailsRepository.findById(id);
    }

    public List<BillDetails> findByBill_ID (Long bill){
        return billDetailsRepository.findByBill_ID(bill);
    }

}
