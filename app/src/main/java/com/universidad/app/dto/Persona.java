package com.universidad.app.dto;

import com.universidad.app.dominio_negocio.Persona;

public class PersonaDTO {
    private String nombre;
    private String identificacion;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String identificacion) {
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

    public static PersonaDTO toDTO(Persona persona) {
        if (persona == null) {
            return null;
        }

        return new PersonaDTO(
                persona.getNombre(),
                persona.getIdentificacion()
        );
    }

    public static Persona fromDTO(PersonaDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Persona(
                dto.getNombre(),
                dto.getIdentificacion()
        );
    }
}