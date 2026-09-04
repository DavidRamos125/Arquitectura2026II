package com.universidad.app.persistencia;

public class H2 implements DataBase{

    @Override
    public void save() {
        System.out.println("Guardando en H2");
    }

    @Override
    public void get() {
        System.out.println("Mostrando informacion de H2");
    }
}
