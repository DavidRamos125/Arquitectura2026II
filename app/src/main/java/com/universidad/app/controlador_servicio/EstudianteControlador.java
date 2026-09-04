package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.DocenteDTO;
import com.universidad.app.dto.EstudianteDTO;

import java.util.List;

public class EstudianteControlador {
    EstudianteServicio estudianteServicio;

    public EstudianteControlador() {
        this.estudianteServicio = new EstudianteServicio();
    }

    public List<EstudianteDTO> get(){
        return estudianteServicio.get();
    }
}
