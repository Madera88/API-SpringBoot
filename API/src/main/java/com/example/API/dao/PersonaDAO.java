package com.example.API.dao;

import com.example.API.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDAO extends CrudRepository<Persona,Long>{
    
}
