package org.example;

import org.example.util.Properties;
import org.example.vista.Vista;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> tiposPlanta = capturarTipos("tipo.planta");
        List<String> tiposAnimal = capturarTipos("tipo.animal");
        new Vista(tiposPlanta, tiposAnimal).iniciar();
    }

    private static List<String> capturarTipos(String property) {
        String valor = Properties.getProperty(property);
        return Arrays.stream(valor.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}