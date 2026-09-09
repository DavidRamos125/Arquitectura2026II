package org.example.interfaces;

import org.example.dominio.agricultura.Planta;

import java.util.List;

public interface ICultivo {
    void regar(Planta planta);
    void cosechar(Planta planta);
    void plantar(Planta planta);
    List<Planta> getPlantas();
}