package com.personal.nexoapi.controller;
import com.personal.nexoapi.model.JewelryType;
import com.personal.nexoapi.service.JewelryTypeService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/JewerlyType")
public class JewerlyTypeController {
    private final JewelryTypeService jewelryTypeService;

    public JewerlyTypeController(JewelryTypeService jewelryTypeService) {
        this.jewelryTypeService = jewelryTypeService;
    }

    //On RestAPI context, the post means: create a new entity
    @PostMapping("/create")
    public ResponseEntity<JewelryType> create(@RequestBody JewelryType jewelryType) {
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(jewelryTypeService.createJewelryType(jewelryType));
    }

    @GetMapping
    public List<JewelryType> findAll() {
        return jewelryTypeService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JewelryType> showDetails(@PathVariable Long id) {
        return jewelryTypeService.findById(id)
        //the .map is a function from optional that works only when the inner object is found, otherwise simply jumps to the next function on the chain
        .map(jewelry -> ResponseEntity.ok(jewelry))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String code) {

        if (name != null) {
            return jewelryTypeService.findByName(name)
            //the :: resumes the function of the lambda parameter (->) helping to write less code with the same result
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }
        if (code != null) {
            return jewelryTypeService.findByCode(code)
                .map(jewelry -> ResponseEntity.ok(jewelry))
                .orElse(ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().body("Debes enviar un nombre o un código");
    }

    @PutMapping("/{id}")
    public JewelryType update(@PathVariable Long id, @RequestBody JewelryType jewelryTypeDetails) {
        return jewelryTypeService.update(id, jewelryTypeDetails);
    }
}
