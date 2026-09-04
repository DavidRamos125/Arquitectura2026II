package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.EstudianteDTO;
import com.universidad.app.dto.MateriaDTO;
import com.universidad.app.persistencia.Persistencia;

import java.util.ArrayList;
import java.util.List;

public class MateriaServicio {
    Persistencia persistencia;

    public MateriaServicio() {
        this.persistencia = new Persistencia();
    }

    public List<MateriaDTO> get(){
        persistencia.get();
        List<MateriaDTO> materias = new ArrayList<>();

        materias.add(new MateriaDTO("POO",4));
        materias.add(new MateriaDTO("Bases de datos",4));
        materias.add(new MateriaDTO("Arquitectura de Software",6));

        return materias;
    }
}
