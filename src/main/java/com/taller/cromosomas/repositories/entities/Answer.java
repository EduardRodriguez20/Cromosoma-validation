package com.taller.cromosomas.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
    private Persona persona;
    private String answer;
}
