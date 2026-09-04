package com.universidad.app.persistencia;

import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    List<DataBase> databases;

    public Persistencia() {
        this.databases = new ArrayList<>();
        this.databases.add(new H2());
        this.databases.add(new MySQL());

    }

    public void get(){
        databases.forEach(DataBase::get);
    }

    public void save(){
        databases.forEach(DataBase::save);
    }
}
