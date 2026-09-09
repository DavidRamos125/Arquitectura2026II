package org.example.dominio.persistencia;

import org.example.dominio.ganaderia.Ganado;

import java.util.List;
import java.util.Optional;

public interface IGanadoRepository {
    void save(Ganado ganado);
    Optional<Ganado> findById(Long id);
    List<Ganado> findAll();
    void update(Ganado ganado);
    void delete(Ganado ganado);
}