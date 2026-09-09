package org.example.dominio.persistencia;

import org.example.dominio.ganaderia.Ganado;

public class GanadoEntity {
    private Long id;
    private String nombre;
    private double peso;

    public GanadoEntity(Long id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    public static GanadoEntity fromGanado(Ganado ganado) {
        return new GanadoEntity(null, ganado.getNombre(), ganado.getPeso());
    }

    public Ganado toGanado() {
        return new Ganado(nombre, peso);
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}