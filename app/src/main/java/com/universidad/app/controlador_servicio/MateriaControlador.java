package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.EstudianteDTO;
import com.universidad.app.dto.MateriaDTO;

import java.util.List;

public class MateriaControlador {
    MateriaServicio materiaServicio;

    public MateriaControlador() {
        this.materiaServicio = new MateriaServicio();
    }

    public List<MateriaDTO> get(){
        return materiaServicio.get();
    }
}
