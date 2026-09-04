package com.universidad.app.dto;

import com.universidad.app.dominio_negocio.Materia;

public class MateriaDTO {
    private String nombre;
    private int creditos;

    public MateriaDTO() {
    }

    public MateriaDTO(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public static MateriaDTO toDTO(Materia materia) {
        if (materia == null) {
            return null;
        }

        return new MateriaDTO(
                materia.getNombre(),
                materia.getCreditos()
        );
    }

    public static Materia fromDTO(MateriaDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Materia(
                dto.getNombre(),
                dto.getCreditos()
        );
    }
}