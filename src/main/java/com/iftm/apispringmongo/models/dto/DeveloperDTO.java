package com.iftm.apispringmongo.models.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

import com.iftm.apispringmongo.models.Address;
import com.iftm.apispringmongo.models.Developer;
import com.iftm.apispringmongo.models.Sector;

public class DeveloperDTO implements Serializable {
    private String id;
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private Address address;
    private Sector sector;

    public DeveloperDTO() { }

    public DeveloperDTO(Developer developer) {
        this.id = developer.getId().toString();
        this.name = developer.getName();
        this.lastName = developer.getLastName();
        this.level = developer.getLevel();
        this.specialization = developer.getSpecialization();
        this.sector = developer.getSector();
        this.address = developer.getAddress();
    }
    public DeveloperDTO(String name, String lastName, String level, String specialization, Address address,
            Sector sector) {
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.specialization = specialization;
        this.address = address;
        this.sector = sector;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }


    
}
