package org.example.dominio.ganaderia;

import org.example.dominio.persistencia.IGanadoRepository;
import org.example.factory.Factory;
import org.example.interfaces.IRebano;

import java.util.ArrayList;
import java.util.List;

public class RebanoLocal implements IRebano {
    private static RebanoLocal instance;
    private final List<Ganado> ganados;
    private final IGanadoRepository repository;

    private RebanoLocal() {
        this.ganados = new ArrayList<>();
        this.repository = Factory.getGanadoRepository();
    }

    public static RebanoLocal getRebanoLocal() {
        if (instance == null) {
            instance = new RebanoLocal();
        }
        return instance;
    }

    public List<Ganado> getGanados() {
        ganados.clear();
        ganados.addAll(repository.findAll());
        return ganados;
    }

    @Override
    public void alimentar(Ganado ganado) {
        double nuevoPeso = ganado.getPeso() + 35;
        if (nuevoPeso > 100) {
            nuevoPeso = 100;
        }
        ganado.setPeso(nuevoPeso);
        repository.update(ganado);
    }

    @Override
    public void sacrificar(Ganado ganado) {
        if (ganado.getPeso() == 100) {
            ganados.remove(ganado);
            repository.delete(ganado);
        }
    }

    @Override
    public void agregar(Ganado ganado) {
        ganados.add(ganado);
        repository.save(ganado);
    }
}