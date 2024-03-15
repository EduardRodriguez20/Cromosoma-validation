package com.taller.cromosomas.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.taller.cromosomas.repositories.entities.Answer;
import com.taller.cromosomas.repositories.entities.Persona;
import com.taller.cromosomas.service.PersonaService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/personas")
@AllArgsConstructor
public class PersonaController {
    
    private PersonaService personaService;

    @GetMapping("/")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona findById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping("/save")
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PostMapping("/update")
    public void update(@PathVariable Long id, @RequestBody Persona persona) {
        personaService.update(id, persona);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }

    @GetMapping("/validacion/{cromosoma}")
    public Answer validCromosoma(@PathVariable String cromosoma) {
        return personaService.validCromosoma(cromosoma);
    }
    

}
