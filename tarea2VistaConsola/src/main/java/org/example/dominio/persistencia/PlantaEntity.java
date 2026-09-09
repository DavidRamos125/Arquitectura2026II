package org.example.dominio.persistencia;

import org.example.dominio.agricultura.Planta;

public class PlantaEntity {
    private Long id;
    private String nombre;
    private double crecimiento;

    public PlantaEntity(Long id, String nombre, double crecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.crecimiento = crecimiento;
    }

    public static PlantaEntity fromPlanta(Planta planta) {
        return new PlantaEntity(null, planta.getNombre(), planta.getCrecimiento());
    }

    public Planta toPlanta() {
        return new Planta(nombre, crecimiento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(double crecimiento) {
        this.crecimiento = crecimiento;
    }
}