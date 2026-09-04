package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.DocenteDTO;
import com.universidad.app.persistencia.Persistencia;

import java.util.List;

public class DocenteControlador {
    DocenteServicio docenteServicio;

    public DocenteControlador() {
        this.docenteServicio = new DocenteServicio();
    }

    public List<DocenteDTO> get(){
        return docenteServicio.get();
    }
}
