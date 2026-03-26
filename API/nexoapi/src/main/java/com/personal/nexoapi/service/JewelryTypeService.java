package com.personal.nexoapi.service;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.model.JewelryType;
import com.personal.nexoapi.repository.JewelryTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryTypeService {

    private final JewelryTypeRepository jewelryTypeRepository;

    public JewelryTypeService(JewelryTypeRepository jewelryTypeRepository) {
        this.jewelryTypeRepository = jewelryTypeRepository;
    }
    
    public JewelryType createJewelryType (JewelryType jewelryType){
        return jewelryTypeRepository.save(jewelryType);
    }

    public List<JewelryType> findAll(){
        return jewelryTypeRepository.findAll();
    }

    public Optional<JewelryType> findById (Long Id){
        return jewelryTypeRepository.findById(Id);
    }

    public Optional<JewelryType> findByName (String name){
        return jewelryTypeRepository.findByName(name);
    }

    public Optional<JewelryType> findByCode (String code){
        return jewelryTypeRepository.findByCode(code);
    }

    public JewelryType update (Long Id, JewelryType jewelryTypeDetails){
        JewelryType jewelryType = jewelryTypeRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("Bisutería no encontrada con el id: " + Id));

        if (jewelryTypeDetails.getName()!=null && !jewelryTypeDetails.getName().trim().isEmpty()) {
            jewelryType.setName(jewelryTypeDetails.getName());
        }

        if (jewelryTypeDetails.getCode()!=null && !jewelryTypeDetails.getCode().trim().isEmpty()) {
            jewelryType.setCode(jewelryTypeDetails.getCode());
        }

        return jewelryTypeRepository.save(jewelryType);
    }
}
