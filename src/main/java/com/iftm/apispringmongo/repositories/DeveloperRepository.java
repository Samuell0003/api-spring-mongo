package com.iftm.apispringmongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iftm.apispringmongo.models.dto.Developer;
@Repository
public interface DeveloperRepository extends MongoRepository <Developer, ObjectId>{
    
}
