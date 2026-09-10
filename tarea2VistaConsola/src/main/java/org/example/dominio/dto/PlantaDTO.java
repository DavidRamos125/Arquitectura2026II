package org.example.dominio.dto;

import org.example.dominio.agricultura.Planta;

public class PlantaDTO {
    private final String nombre;
    private final double crecimiento;

    public PlantaDTO(String nombre, double crecimiento) {
        this.nombre = nombre;
        this.crecimiento = crecimiento;
    }

    public static PlantaDTO fromPlanta(Planta planta) {
        return new PlantaDTO(planta.getNombre(), planta.getCrecimiento());
    }

    public Planta toPlanta() {
        return new Planta(nombre, crecimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public double getCrecimiento() {
        return crecimiento;
    }

    @Override
    public String toString() {
        return "PlantaDTO{" +
                "nombre='" + nombre + '\'' +
                ", crecimiento=" + crecimiento +
                '}';
    }
}