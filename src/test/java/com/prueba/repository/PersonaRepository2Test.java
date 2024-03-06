package com.prueba.repository;

import com.prueba.entiity.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonaRepository2Test {
    @Autowired
    PersonaRepository repository;

    @BeforeEach
    void setUp() {
        Persona persona= Persona.builder()
                .id(1)
                .edad(15)
                .nombre("juan")
                .correo("juan@gmail.com")
                .idDepartamento(11)
                .direccion("domicilio conocido")
                .build();
        repository.save(persona);
    }


    @Test
    void findById(){
       Persona per =repository.findById(1L).orElseThrow();
       assertEquals(1, per.getId());
    }
    @Test
    void name() {
        List<Persona> name= repository.findByNombreContaining("juan");
        assertEquals(1, name.size());
    }

    @Test
    void deleted() {
        repository.deleteById(1L);
        List<Persona> data=repository.findAll();
        System.out.println(data);
        assertEquals(0,data.size());
    }


}