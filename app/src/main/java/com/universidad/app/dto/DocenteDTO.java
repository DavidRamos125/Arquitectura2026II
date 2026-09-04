package com.universidad.app.dto;

import com.universidad.app.dominio_negocio.Docente;

public class DocenteDTO {
    private String nombre;
    private String identificacion;

    public DocenteDTO() {
    }

    public DocenteDTO(String nombre, String identificacion) {
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

    public static DocenteDTO toDTO(Docente docente) {
        if (docente == null) {
            return null;
        }

        return new DocenteDTO(
                docente.getNombre(),
                docente.getIdentificacion()
        );
    }

    public static Docente fromDTO(DocenteDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Docente(
                dto.getNombre(),
                dto.getIdentificacion()
        );
    }
}