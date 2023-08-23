
package com.example.API.controller;

import com.example.API.model.Persona;
import com.example.API.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(){
        return "Bienvenido a mi API";
    }
    
    @GetMapping("/personas")
    public List<Persona> listar(){
        return personaService.listado();
    }
    
    @GetMapping("/persona/{idPersona}")
    public Persona persona(@PathVariable Long idPersona){
        return personaService.buscar(idPersona);
    }
    @GetMapping("/guardar/{nombre}/{apellido}/{email}/{telefono}")
    public String persona(@PathVariable String nombre,@PathVariable String apellido,
            @PathVariable String email,@PathVariable String telefono){
        Persona guardar = new Persona();
        guardar.setNombre(nombre);
        guardar.setApellido(apellido);
        guardar.setEmail(email);
        guardar.setTelefono(telefono);
        
        personaService.guardar(guardar);
        
        return "Persona Guardada con Exito!!";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminarPersona(@PathVariable Long idPersona){
        try{
        personaService.eliminar(idPersona);
        
        return "Persona con id: "+idPersona+" Borrada";      
        }catch (Exception e){
            return "Error al borrar a la Persona indicada";
        }
    }
    
}
