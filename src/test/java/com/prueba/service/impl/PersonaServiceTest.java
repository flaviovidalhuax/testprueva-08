package com.prueba.service.impl;

import com.prueba.entiity.Persona;
import com.prueba.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonaServiceTest {
    @MockBean
    PersonaRepository personaRepository;
    @Autowired
    PersonaService personaService;

    @BeforeEach
    void beforeAll() {
        Persona per2=Persona.builder()
                .id(3)
                .edad(12)
                .nombre("maria")
                .direccion("conocido")
                .correo("maria@gmail.com")
                .idDepartamento(412)
                .build();
    }

    @Test
    void saveserviceTest() {
        Persona per=Persona.builder()
                .id(2)
                .edad(23)
                .nombre("pedro")
                .direccion("conocido")
                .correo("pedro@gmail.com")
                .idDepartamento(12)
                .build();
        when(personaRepository.save(per)).thenReturn(per);
        Persona data =personaService.create(per);
        assertNotNull(data);
        assertEquals(2, data.getId());
    }

    @Test
    void findByIdServiceTest() {
        Persona per=Persona.builder()
                .id(2)
                .edad(23)
                .nombre("pedro")
                .direccion("conocido")
                .correo("pedro@gmail.com")
                .idDepartamento(12)
                .build();
       when(personaRepository.findById(2L)).thenReturn(Optional.ofNullable(per));
       Persona data = personaService.findById(2L);
       assertEquals(2,data.getId());
    }

    @Test
    void deleteServiceTest() {
        Persona per=Persona.builder()
                .id(2)
                .edad(23)
                .nombre("pedro")
                .direccion("conocido")
                .correo("pedro@gmail.com")
                .idDepartamento(12)
                .build();
        doNothing().when(personaRepository).deleteById(2L);
        personaService.delete(2L);
        verify(personaRepository,times(1)).deleteById(2L);
    }

    @Test
    void findAllServiceTest() {

        List<Persona> arrPersona= Arrays.asList(
                new Persona(1,"juan","conocido",12,15,"juan@gmail.com"),
                new Persona(2,"felipe","conocido",10,20,"felipe@gmail.com")
        );
        when(personaRepository.findAll()).thenReturn(arrPersona);
        List<Persona> data=personaService.read();
        assertNotNull(data);
        assertEquals(2,data.size());
        verify(personaRepository,times(1)).findAll();
    }
}