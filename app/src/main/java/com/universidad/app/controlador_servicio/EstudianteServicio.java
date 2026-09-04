package com.universidad.app.controlador_servicio;

import com.universidad.app.dto.DocenteDTO;
import com.universidad.app.dto.EstudianteDTO;
import com.universidad.app.persistencia.Persistencia;

import java.util.ArrayList;
import java.util.List;

    public class EstudianteServicio {
        Persistencia persistencia;

        public EstudianteServicio() {
            this.persistencia = new Persistencia();
        }

        public List<EstudianteDTO> get(){
            persistencia.get();
            List<EstudianteDTO> estudiantes = new ArrayList<>();

            estudiantes.add(new EstudianteDTO("Juan","1234"));
            estudiantes.add(new EstudianteDTO("Jhorman","3566"));
            estudiantes.add(new EstudianteDTO("Fabian","6743"));

            return estudiantes;
        }
    }
