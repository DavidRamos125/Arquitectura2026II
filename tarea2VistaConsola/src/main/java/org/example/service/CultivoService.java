package org.example.service;

import org.example.dominio.agricultura.Planta;
import org.example.dominio.dto.PlantaDTO;
import org.example.factory.Factory;
import org.example.interfaces.ICultivo;

import java.util.List;

public class CultivoService {
    private static CultivoService instance;
    private final ICultivo cultivo;

    private CultivoService() {
        this.cultivo = Factory.getCultivo();
    }

    public static CultivoService getCultivoService() {
        if (instance == null) {
            instance = new CultivoService();
        }
        return instance;
    }

    public void plantar(String nombre) {
        cultivo.plantar(Factory.getPlanta(nombre, 0));
    }

    public void regar(String nombre) {
        cultivo.regar(buscar(nombre));
    }

    public void cosechar(String nombre) {
        cultivo.cosechar(buscar(nombre));
    }

    public List<PlantaDTO> listar() {
        return cultivo.getPlantas().stream()
                .map(PlantaDTO::fromPlanta)
                .toList();
    }

    private Planta buscar(String nombre) {
        return cultivo.getPlantas().stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe una planta llamada " + nombre));
    }
}