package com.example.API.service;

import com.example.API.dao.PersonaDAO;
import com.example.API.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaDAO personaDao;
    
    public List<Persona> listado(){
        return (List<Persona>) personaDao.findAll();
    }
    
    public Persona buscar(long idPersona){
       return personaDao.findById(idPersona).orElse(null);
    }
    
    public void guardar(Persona persona){
        personaDao.save(persona);
    }
    
    public void eliminar(long idPersona){
        Persona personaEliminar = personaDao.findById(idPersona).orElse(null);
        personaDao.delete(personaEliminar);
    }
}
