package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.DocenteDTO;
import com.universidad.app.persistencia.Persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocenteServicio {
    Persistencia persistencia;

    public DocenteServicio() {
        this.persistencia = new Persistencia();
    }

    public List<DocenteDTO> get(){
        persistencia.get();
        List<DocenteDTO> docentes = new ArrayList<>();

        docentes.add(new DocenteDTO("Roger","1234"));
        docentes.add(new DocenteDTO("Nestor","3566"));
        docentes.add(new DocenteDTO("Juan","6743"));
        docentes.add(new DocenteDTO("Marco","2772"));

        return docentes;
    }
}
