package org.example.dominio.persistencia;

import org.example.dominio.agricultura.Planta;

import java.util.List;
import java.util.Optional;

public interface IPlantaRepository {
    void save(Planta planta);
    Optional<Planta> findById(Long id);
    List<Planta> findAll();
    void update(Planta planta);
    void delete(Planta planta);
}