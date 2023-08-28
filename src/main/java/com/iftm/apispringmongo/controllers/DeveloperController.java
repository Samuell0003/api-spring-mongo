package com.iftm.apispringmongo.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable("id") ObjectId id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> save(@RequestBody Developer developer) {
        return service.save(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById (@PathVariable("id") ObjectId id) {
        return service.deleteById(id);
    }
}
