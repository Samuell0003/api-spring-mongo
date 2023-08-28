package com.iftm.apispringmongo.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iftm.apispringmongo.models.Developer;
import com.iftm.apispringmongo.models.dto.DeveloperDTO;
import com.iftm.apispringmongo.services.DeveloperService;

@RequestMapping("api/v1/developer")
@RestController
public class DeveloperController {
    
    private DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable("id") ObjectId id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> save(@RequestBody Developer developer) {
        return service.save(developer);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteById (@PathVariable("id") ObjectId id) {
        return service.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> updateById(@RequestBody DeveloperDTO developer) {
        return service.update(developer);
    }
}
