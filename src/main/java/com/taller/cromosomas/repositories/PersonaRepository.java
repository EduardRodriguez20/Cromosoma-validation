package com.taller.cromosomas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taller.cromosomas.repositories.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
}
