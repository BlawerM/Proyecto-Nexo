package com.personal.nexoapi.controller;
import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.model.DesignType;
import com.personal.nexoapi.service.DesignTypeService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/DesignType")
public class DesignTypeController {
    private final DesignTypeService designTypeService;

    public DesignTypeController(DesignTypeService designTypeService) {
        this.designTypeService = designTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<DesignType> create(@RequestBody DesignType designType) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(designTypeService.createDesignType(designType));
    }
    
    @GetMapping
    public List<DesignType> findAll() {
        return designTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignType> showDetails(@PathVariable Long id) {
        return designTypeService.findById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String code) {

        if (name != null) {
            return designTypeService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }
        if (code != null) {
            return designTypeService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().body("Debes enviar un nombre o un código");
    }

    @PutMapping("/{id}")
    public DesignType update(@PathVariable Long id, @RequestBody DesignType designTypeDetails) {
        return designTypeService.update(id, designTypeDetails);
    }

}
