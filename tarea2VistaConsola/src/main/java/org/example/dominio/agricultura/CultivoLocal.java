package org.example.dominio.agricultura;

import org.example.dominio.persistencia.IPlantaRepository;
import org.example.factory.Factory;
import org.example.interfaces.ICultivo;

import java.util.ArrayList;
import java.util.List;

public class CultivoLocal implements ICultivo {
    private static CultivoLocal instance;
    private final List<Planta> plantas;
    private final IPlantaRepository repository;

    private CultivoLocal() {
        this.plantas = new ArrayList<>();
        this.repository = Factory.getPlantaRepository();
    }

    public static CultivoLocal getCultivoLocal() {
        if (instance == null) {
            instance = new CultivoLocal();
        }
        return instance;
    }

    public List<Planta> getPlantas() {
        plantas.clear();
        plantas.addAll(repository.findAll());
        return plantas;
    }

    @Override
    public void regar(Planta planta) {
        double nuevoCrecimiento = planta.getCrecimiento() + 35;
        if (nuevoCrecimiento > 100) {
            nuevoCrecimiento = 100;
        }
        planta.setCrecimiento(nuevoCrecimiento);
        repository.update(planta);
    }

    @Override
    public void cosechar(Planta planta) {
        if (planta.getCrecimiento() == 100) {
            plantas.remove(planta);
            repository.delete(planta);
        }
    }

    @Override
    public void plantar(Planta planta) {
        plantas.add(planta);
        repository.save(planta);
    }
}