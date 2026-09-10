package org.example.vista;

import org.example.dominio.dto.GanadoDTO;
import org.example.dominio.dto.PlantaDTO;
import org.example.factory.Factory;
import org.example.service.CultivoService;
import org.example.service.RebanoService;

import java.util.List;
import java.util.Scanner;

public class Vista {
    private final Scanner scanner = new Scanner(System.in);
    private final CultivoService cultivoService = Factory.getCultivoService();
    private final RebanoService rebanoService = Factory.getRebanoService();
    private final List<String> tiposPlanta;
    private final List<String> tiposAnimal;

    public Vista(List<String> tiposPlanta, List<String> tiposAnimal) {
        this.tiposPlanta = tiposPlanta;
        this.tiposAnimal = tiposAnimal;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Manejar Plantas");
            System.out.println("2. Manejar Ganado");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerOpcion();
            switch (opcion) {
                case 1 -> menuPlantas();
                case 2 -> menuGanado();
                case 3 -> salir = true;
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private void menuPlantas() {
        boolean volver = false;
        while (!volver) {
            mostrarPlantas();
            System.out.println("\n=== MANEJAR PLANTAS ===");
            System.out.println("1. Plantar");
            System.out.println("2. Regar");
            System.out.println("3. Cosechar");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerOpcion();
            switch (opcion) {
                case 1 -> plantar();
                case 2 -> regar();
                case 3 -> cosechar();
                case 4 -> volver = true;
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private void menuGanado() {
        boolean volver = false;
        while (!volver) {
            mostrarGanado();
            System.out.println("\n=== MANEJAR GANADO ===");
            System.out.println("1. Agregar");
            System.out.println("2. Alimentar");
            System.out.println("3. Sacrificar");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerOpcion();
            switch (opcion) {
                case 1 -> agregar();
                case 2 -> alimentar();
                case 3 -> sacrificar();
                case 4 -> volver = true;
                default -> System.out.println("Opcion invalida.");
            }
        }
    }

    private void mostrarPlantas() {
        List<PlantaDTO> plantas = cultivoService.listar();
        if (plantas.isEmpty()) {
            System.out.println("\nNo hay plantas.");
        } else {
            System.out.println("\n=== PLANTAS EXISTENTES ===");
            for (int i = 0; i < plantas.size(); i++) {
                PlantaDTO p = plantas.get(i);
                System.out.println("  " + (i + 1) + ". " + p.getNombre() + " (crecimiento: " + p.getCrecimiento() + ")");
            }
        }
    }

    private void mostrarGanado() {
        List<GanadoDTO> ganados = rebanoService.listar();
        if (ganados.isEmpty()) {
            System.out.println("\nNo hay ganado.");
        } else {
            System.out.println("\n=== GANADO EXISTENTE ===");
            for (int i = 0; i < ganados.size(); i++) {
                GanadoDTO g = ganados.get(i);
                System.out.println("  " + (i + 1) + ". " + g.getNombre() + " (peso: " + g.getPeso() + ")");
            }
        }
    }

    private void plantar() {
        System.out.println("\nSeleccione el tipo de planta:");
        mostrarTipos(tiposPlanta);
        int tipo = leerOpcion();
        if (tipo < 1 || tipo > tiposPlanta.size()) {
            System.out.println("Tipo invalido.");
            return;
        }
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        cultivoService.plantar(componerNombre(nombre, tiposPlanta.get(tipo - 1)));
        System.out.println("Planta agregada.");
    }

    private void regar() {
        PlantaDTO planta = pedirPlantaPorNumero();
        if (planta != null) {
            cultivoService.regar(planta.getNombre());
            System.out.println("Planta regada.");
        }
    }

    private void cosechar() {
        PlantaDTO planta = pedirPlantaPorNumero();
        if (planta != null) {
            if (planta.getCrecimiento() == 100) {
                cultivoService.cosechar(planta.getNombre());
                System.out.println("Planta " + planta.getNombre() + " cosechada.");
            } else {
                System.out.println("Vas a cosechar hojas? " + planta.getNombre()
                        + " no esta al 100 de su poder (crecimiento: " + planta.getCrecimiento() + ")");
            }
        }
    }

    private void agregar() {
        System.out.println("\nSeleccione el tipo de animal:");
        mostrarTipos(tiposAnimal);
        int tipo = leerOpcion();
        if (tipo < 1 || tipo > tiposAnimal.size()) {
            System.out.println("Tipo invalido.");
            return;
        }
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        rebanoService.agregar(componerNombre(nombre, tiposAnimal.get(tipo - 1)));
        System.out.println("Ganado agregado.");
    }

    private void alimentar() {
        GanadoDTO ganado = pedirGanadoPorNumero();
        if (ganado != null) {
            rebanoService.alimentar(ganado.getNombre());
            System.out.println("Ganado alimentado.");
        }
    }

    private void sacrificar() {
        GanadoDTO ganado = pedirGanadoPorNumero();
        if (ganado != null) {
            if (ganado.getPeso() == 100) {
                rebanoService.sacrificar(ganado.getNombre());
                System.out.println(ganado.getNombre() + " sacrificado.");
            } else {
                System.out.println(ganado.getNombre() + " se ha resistido, no ha vivido lo suficiente"
                        + " (tiene que tener 100 de peso, ahora tiene " + ganado.getPeso() + ")");
            }
        }
    }

    private PlantaDTO pedirPlantaPorNumero() {
        List<PlantaDTO> plantas = cultivoService.listar();
        if (plantas.isEmpty()) {
            System.out.println("No hay plantas.");
            return null;
        }
        System.out.print("Seleccione el numero de la planta: ");
        int num = leerOpcion();
        if (num < 1 || num > plantas.size()) {
            System.out.println("Numero invalido.");
            return null;
        }
        return plantas.get(num - 1);
    }

    private GanadoDTO pedirGanadoPorNumero() {
        List<GanadoDTO> ganados = rebanoService.listar();
        if (ganados.isEmpty()) {
            System.out.println("No hay ganado.");
            return null;
        }
        System.out.print("Seleccione el numero del animal: ");
        int num = leerOpcion();
        if (num < 1 || num > ganados.size()) {
            System.out.println("Numero invalido.");
            return null;
        }
        return ganados.get(num - 1);
    }

    private String componerNombre(String nombre, String tipo) {
        return nombre + "-" + tipo;
    }

    private void mostrarTipos(List<String> tipos) {
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + ". " + tipos.get(i));
        }
    }

    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}