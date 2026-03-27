package com.personal.nexoapi.service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.repository.DesignTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DesignTypeService {
    DesignTypeRepository designTypeRepository;

	public DesignTypeService(DesignTypeRepository designTypeRepository) {
		this.designTypeRepository = designTypeRepository;
	}

    public DesignType createDesignType(DesignType designType){
        try {
            return designTypeRepository.save(designType);
        } catch (DataIntegrityViolationException e) {
            String error = e.getMostSpecificCause().getMessage();
            if (error.contains("uq_name")) {
                throw new RuntimeException("El tipo de diseño " + designType.getName() + " ya existe.");
            }
            if (error.contains("uq_code")) {
                throw new RuntimeException("El código " + designType.getCode() + " ya existe.");
            }
            throw new RuntimeException("Error en la base de datos: " + error);
        }
    }

    public List<DesignType> findAll (){
        return designTypeRepository.findAll();
    }

    public Optional<DesignType> findById (Long id){
        return designTypeRepository.findById(id);
    }

    public Optional<DesignType> findByName (String name){
        return designTypeRepository.findByName(name);
    }

    public Optional<DesignType> findByCode (String code){
        return designTypeRepository.findByCode(code);
    }

    public DesignType update (Long id, DesignType designTypeDetails){
        DesignType designType = designTypeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Diseño no encontrado con el id: " + id));

        if (designTypeDetails.getName() != null && !designTypeDetails.getName().trim().isEmpty()) {
            designType.setName(designTypeDetails.getName());
        }

        if (designTypeDetails.getCode() != null && !designTypeDetails.getCode().trim().isEmpty()) {
            designType.setCode(designTypeDetails.getCode());
        }

        return designTypeRepository.save(designType);
    }

}
