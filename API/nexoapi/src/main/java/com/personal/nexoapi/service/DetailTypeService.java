package com.personal.nexoapi.service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.DetailType;
import com.personal.nexoapi.repository.DetailTypeRepository;
import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.repository.DesignTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DetailTypeService {
    DetailTypeRepository detailTypeRepository;
    DesignTypeRepository designTypeRepository;

    public DetailType createDetailType (DetailType detailType){
        Long designTypeId = detailType.getDesignType().getID();

        try {
            DesignType designType = designTypeRepository.findById(designTypeId)
            .orElseThrow(() -> new RuntimeException("El diseño no existe"));

            if (detailTypeRepository.existsByNameandDesign_ID(detailType.getName(), designTypeId)) {
                throw new RuntimeException("Ya existe este tipo de detalle en el diseño actual");
            }
            detailType.setDesignType(designType);
            return detailTypeRepository.save(detailType);

        } catch (DataIntegrityViolationException e) {
            String error = e.getMostSpecificCause().getMessage();
            if (error.contains("uq_name")) {
                throw new RuntimeException("El tipo de detalle " + detailType.getName() + " ya existe.");
            }
            if (error.contains("uq_code")) {
                throw new RuntimeException("El código " + detailType.getCode() + " ya existe.");
            }
            throw new RuntimeException("Error en la base de datos: " + error);
        }
    }

    public List<DetailType> findAll(){
        return detailTypeRepository.findAll();
    }

    public Optional<DetailType> findById(Long id){
        return detailTypeRepository.findById(id);
    }

    public Optional<DetailType> findByName (String name){
        return detailTypeRepository.findByName(name);
    }

    public List<DetailType> findByDesignType (Long DesignId){
        return detailTypeRepository.findByDesignType(DesignId);
    }

    public Optional<DetailType> findByCode (String code){
        return detailTypeRepository.findByCode(code);
    }

    public DetailType update (Long id, DetailType detailTypeDetails){
        DetailType detailType = detailTypeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Detalle no encontrada con el id: " + id));

        if (detailTypeDetails.getName()!= null && !detailTypeDetails.getName().trim().isEmpty()) {
            detailType.setName(detailTypeDetails.getName());
        }

        if (detailTypeDetails.getCode()!= null && !detailTypeDetails.getCode().trim().isEmpty()) {
            detailType.setCode(detailTypeDetails.getCode());
        }

        return detailTypeRepository.save(detailType);
    }
}
