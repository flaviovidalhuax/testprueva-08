package com.prueba.repository;

import com.prueba.entiity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
public List<Persona> findByNombreContaining(String name);
public List<Persona> findByDireccionContaining(String direccion);
public List<Persona> findByNombreContainingIgnoreCaseAndEdadAndDireccionContainingIgnoreCase(String name, Long edad, String direccion);
public List<Persona> findByNombreContainingIgnoreCaseAndEdadGreaterThanAndDireccionContainingIgnoreCase(String name, Long edad, String direccion);

@Query(value = "select pd.id, p.nombre, p.direccion, p.edad, d.precio, d.m2,p.id_departamento  from  departamento d\n" +
        "join persona_departamento pd on d.id = pd.departamento_id\n" +
        "join persona p on p.id = pd.persona_id_departamento",nativeQuery = true)
    public List<Object[]> joinTables();

}
