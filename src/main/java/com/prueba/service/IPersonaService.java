package com.prueba.service;

import com.prueba.entiity.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> read();
    public void delete(Long id);
    public Persona create(Persona persona);
    public Persona update(Persona persona);
    public Persona findById(Long id);
    public List<Persona> findByName(String name);
    public List<Persona> findByDireccion(String direccion);
    public List<Persona> filter(String name,Long edad,String direccion);
    public List<Object[]> joinTables();



}
