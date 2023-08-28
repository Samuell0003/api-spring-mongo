package com.iftm.apispringmongo.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iftm.apispringmongo.models.Developer;
import com.iftm.apispringmongo.models.dto.DeveloperDTO;
import com.iftm.apispringmongo.repositories.DeveloperRepository;

@Service
public class DeveloperService {
    
    private DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<DeveloperDTO>> findAll() {
        var dbDeveloper = repository.findAll();
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        var dtoDeveloper = dbDeveloper.stream().map( e -> {
            return new DeveloperDTO(e);
        }).collect(Collectors.toList());
        
        return ResponseEntity.ok(dtoDeveloper);
    }

    public ResponseEntity<DeveloperDTO> findById(ObjectId id) {
        var dbDeveloper = repository.findById(id);
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new DeveloperDTO(dbDeveloper.get()));
    }

    public ResponseEntity<DeveloperDTO> update(DeveloperDTO developer) {
        if (developer.getId() == null || developer.getId().toString().isBlank())
            return ResponseEntity.badRequest().build();

        var dbDeveloper = repository.findById(new ObjectId(developer.getId()));
        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        dbDeveloper.get().setLastName(developer.getLastName());
        dbDeveloper.get().setName(developer.getName());
        dbDeveloper.get().setLevel(developer.getLevel());
        dbDeveloper.get().setSector(developer.getSector());
        dbDeveloper.get().setSpecialization(developer.getSpecialization());
        dbDeveloper.get().setAddress(developer.getAddress());

        return ResponseEntity.ok(new DeveloperDTO(repository.save(dbDeveloper.get())));

    }

    public ResponseEntity<DeveloperDTO> save(Developer developer) {
        return ResponseEntity.ok(new DeveloperDTO(repository.save(developer)));
    }

    public ResponseEntity<?> deleteById(ObjectId id) {
        repository.deleteById(id);

        if (repository.findById(id).isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }
}
