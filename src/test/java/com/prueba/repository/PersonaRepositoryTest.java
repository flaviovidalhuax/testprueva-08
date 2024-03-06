package com.prueba.repository;

import com.prueba.entiity.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonaRepositoryTest {
    @Autowired
    PersonaRepository repository;

    @Test
    @DisplayName("metodo all array")
    void findallTest() {
        Persona persona= Persona.builder()
                        .id(1)
                                .edad(15)
                                        .nombre("juan")
                                                .correo("juan@gmail.com")
                                                        .idDepartamento(11)
                                                                .direccion("domicilio conocido")
                                                                        .build();
        repository.save(persona);
       List<Persona> data =repository.findAll();
        System.out.println(data);
       assertEquals(1,data.size());
    }

    @Test
    void findById() {
        Persona persona= Persona.builder()
                .id(1)
                .edad(15)
                .nombre("juan")
                .correo("juan@gmail.com")
                .idDepartamento(11)
                .direccion("domicilio conocido")
                .build();
        repository.save(persona);
        Optional<Persona> per=repository.findById(1L);
        assertEquals("juan",per.orElseThrow().getNombre());
        assertEquals(15, per.orElseThrow().getEdad());
        assertEquals(1, per.orElseThrow().getId());
        assertEquals("juan@gmail.com", per.orElseThrow().getCorreo());
        assertEquals(11, per.orElseThrow().getIdDepartamento());
        assertEquals("domicilio conocido", per.orElseThrow().getDireccion());

    }


    @Test
    void deleteById() {
        Persona persona= Persona.builder()
                .id(1)
                .edad(15)
                .nombre("juan")
                .correo("juan@gmail.com")
                .idDepartamento(11)
                .direccion("domicilio conocido")
                .build();
        repository.save(persona);
        Persona per=repository.findById(1L).orElseThrow();
        assertEquals("juan",per.getNombre());
        assertEquals(15, per.getEdad());
        assertEquals(1, per.getId());
        assertEquals("juan@gmail.com", per.getCorreo());
        assertEquals(11, per.getIdDepartamento());
        assertEquals("domicilio conocido", per.getDireccion());
        repository.deleteById(1L);
        List<Persona> data=repository.findAll();
        assertEquals(0,data.size());

    }
}