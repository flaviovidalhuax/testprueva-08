package com.prueba.service.impl;

import com.prueba.entiity.Persona;
import com.prueba.repository.PersonaRepository;
import com.prueba.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> read() {

        return personaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElseThrow(()->new RuntimeException("Ninguna persona econtrada "+id));
    }

    @Override
    public List<Persona> findByName(String name) {
        return personaRepository.findByNombreContaining(name);
    }

    @Override
    public List<Persona> findByDireccion(String direccion) {
        return personaRepository.findByDireccionContaining(direccion);
    }

    @Override
    public List<Persona> filter(String name, Long edad, String direccion) {
        if (edad==0){
            return personaRepository.findByNombreContainingIgnoreCaseAndEdadGreaterThanAndDireccionContainingIgnoreCase(name,edad,direccion);
        }else{
            return personaRepository.findByNombreContainingIgnoreCaseAndEdadAndDireccionContainingIgnoreCase(name,edad,direccion);
        }

    }

    @Override
    public List<Object[]> joinTables() {
        return personaRepository.joinTables();
    }


}
