package com.universidad.app.persistencia;

public class MySQL implements DataBase{
    @Override
    public void save() {
        System.out.print("Guardando en MySQL");
    }

    @Override
    public void get() {
        System.out.print("Mostrando informacion de MySQL");
    }


}
