package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.CursoInscritoDTO;

import java.util.List;

public class CursoInscritoControler {
    CursoInscritoServicio cursoInscritoServicio;

    public CursoInscritoControler() {
        this.cursoInscritoServicio = new CursoInscritoServicio();
    }

    public List<CursoInscritoDTO> get(){
        return cursoInscritoServicio.get();
    }
}
