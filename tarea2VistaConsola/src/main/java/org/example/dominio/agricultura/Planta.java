package org.example.dominio.agricultura;

public class Planta {
    private String nombre;
    private double crecimiento;

    public Planta(String nombre, double crecimiento) {
        this.nombre = nombre;
        this.crecimiento = crecimiento;
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

    @Override
    public String toString() {
        return "Planta{" +
                "nombre='" + nombre + '\'' +
                ", crecimiento=" + crecimiento +
                '}';
    }
}
