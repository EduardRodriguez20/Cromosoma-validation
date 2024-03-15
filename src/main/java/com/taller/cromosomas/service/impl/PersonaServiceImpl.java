package com.taller.cromosomas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taller.cromosomas.repositories.PersonaRepository;
import com.taller.cromosomas.repositories.entities.Answer;
import com.taller.cromosomas.repositories.entities.Persona;
import com.taller.cromosomas.service.PersonaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @SuppressWarnings("null")
    @Override
    public void update(Long id, Persona persona) {
        Optional<Persona> existPerson = personaRepository.findById(id);
        existPerson.ifPresent(p -> {
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setDireccion(persona.getDireccion());
            p.setEmail(persona.getEmail());
            p.setCromosoma(persona.getCromosoma());
            personaRepository.save(persona);
        });
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Persona> existPerson = personaRepository.findById(id);
        existPerson.ifPresent(p -> personaRepository.delete(p));
    }

    @Override
    public Answer validCromosoma(String cromosoma) {
        List<Persona> listPersonas = (List<Persona>) personaRepository.findAll();
        Persona person = null;
        double mayorCoincidencia = 0;
        double coincidencias = 0;
        if (listPersonas.isEmpty()) {
            return new Answer(null,"No hay datos de personas");
        }else {
            for (Persona persona : listPersonas) {
                coincidencias = 0;
                for(int i = 0; i < cromosoma.length(); i++){
                    if (cromosoma.charAt(i) == persona.getCromosoma().charAt(i)) {
                        coincidencias++;
                    }
                }
                if (coincidencias > mayorCoincidencia) {
                    person = persona;
                    mayorCoincidencia = coincidencias;
                }
            }
        }
        double porcentajeParentesco = (double) mayorCoincidencia / cromosoma.length() * 100;
        return new Answer(person, "Porcentaje de parentezco: " + porcentajeParentesco + "%");
    }
    
}
