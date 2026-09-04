package com.universidad.app.dto;

import com.universidad.app.dominio_negocio.Estudiante;

public class EstudianteDTO {
    private String nombre;
    private String identificacion;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }

        return new EstudianteDTO(
                estudiante.getNombre(),
                estudiante.getIdentificacion()
        );
    }

    public static Estudiante fromDTO(EstudianteDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Estudiante(
                dto.getNombre(),
                dto.getIdentificacion()
        );
    }
}