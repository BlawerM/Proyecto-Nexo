package com.personal.nexoapi.service;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.JewelryType;
import com.personal.nexoapi.repository.JewelryTypeRepository;

@Service
public class JewelryTypeService {

    private final JewelryTypeRepository jewelryTypeRepository;

    public JewelryTypeService(JewelryTypeRepository jewelryTypeRepository) {
        this.jewelryTypeRepository = jewelryTypeRepository;
    }
    

//Create
//List
//Find
//Delete???
//Update
}
