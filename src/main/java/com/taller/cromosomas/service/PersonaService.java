package com.taller.cromosomas.service;

import java.util.List;

import com.taller.cromosomas.repositories.entities.Answer;
import com.taller.cromosomas.repositories.entities.Persona;

public interface PersonaService {

    public List<Persona> findAll();

    public Persona findById(Long id);
    
    public Persona save(Persona persona);

    public void update(Long id, Persona persona);

    public void delete(Long id);

    public Answer validCromosoma(String cromosoma);
    

}
