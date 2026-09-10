package org.example.dominio.dto;

import org.example.dominio.ganaderia.Ganado;

public class GanadoDTO {
    private final String nombre;
    private final double peso;

    public GanadoDTO(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public static GanadoDTO fromGanado(Ganado ganado) {
        return new GanadoDTO(ganado.getNombre(), ganado.getPeso());
    }

    public Ganado toGanado() {
        return new Ganado(nombre, peso);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "GanadoDTO{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                '}';
    }
}