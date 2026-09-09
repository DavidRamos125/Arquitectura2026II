package org.example.service;

import org.example.dominio.ganaderia.Ganado;
import org.example.factory.Factory;
import org.example.interfaces.IRebano;

import java.util.List;

public class RebanoService {
    private static RebanoService instance;
    private final IRebano rebano;

    private RebanoService() {
        this.rebano = Factory.getRebano();
    }

    public static RebanoService getRebanoService() {
        if (instance == null) {
            instance = new RebanoService();
        }
        return instance;
    }

    public void agregar(String nombre) {
        rebano.agregar(Factory.getGanado(nombre, 0));
    }

    public void alimentar(String nombre) {
        rebano.alimentar(buscar(nombre));
    }

    public void sacrificar(String nombre) {
        rebano.sacrificar(buscar(nombre));
    }

    public List<Ganado> listar() {
        return rebano.getGanados();
    }

    private Ganado buscar(String nombre) {
        return rebano.getGanados().stream()
                .filter(g -> g.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe un ganado llamado " + nombre));
    }
}