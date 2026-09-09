package org.example.interfaces;

import org.example.dominio.ganaderia.Ganado;

import java.util.List;

public interface IRebano {
    void alimentar(Ganado ganado);
    void sacrificar(Ganado ganado);
    void agregar(Ganado ganado);
    List<Ganado> getGanados();
}