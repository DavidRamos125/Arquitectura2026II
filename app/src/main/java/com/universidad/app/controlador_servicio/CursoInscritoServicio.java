package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.CursoInscritoDTO;
import com.universidad.app.dto.DocenteDTO;
import com.universidad.app.dto.EstudianteDTO;
import com.universidad.app.dto.MateriaDTO;
import com.universidad.app.persistencia.Persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CursoInscritoServicio {
    Persistencia persistencia;

    public CursoInscritoServicio() {
        this.persistencia = new Persistencia();
    }

    public List<CursoInscritoDTO> get(){
        persistencia.get();
        List<CursoInscritoDTO> cursosInscritos = new ArrayList<>();

        cursosInscritos.add(
                new CursoInscritoDTO(
                        new DocenteDTO("Roger","1234"),
                        new EstudianteDTO("Juan","1234"),
                        new MateriaDTO("Arquitectura de Software",6),
                        BigDecimal.valueOf(4.5)
                )
        );
        cursosInscritos.add(
                new CursoInscritoDTO(
                        new DocenteDTO("Roger","1234"),
                        new EstudianteDTO("Jhorman","3566"),
                        new MateriaDTO("Arquitectura de Software",6),
                        BigDecimal.valueOf(4.3)
                )
        );
        cursosInscritos.add(
                new CursoInscritoDTO(
                        new DocenteDTO("Roger","1234"),
                        new EstudianteDTO("Fabian","6743"),
                        new MateriaDTO("Arquitectura de Software",6),
                        BigDecimal.valueOf(4.4)
                )
        );

        return cursosInscritos;
    }
}
