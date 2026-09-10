package org.example.factory;

import org.example.dominio.agricultura.CultivoLocal;
import org.example.dominio.agricultura.Planta;
import org.example.dominio.dto.GanadoDTO;
import org.example.dominio.dto.PlantaDTO;
import org.example.dominio.ganaderia.Ganado;
import org.example.dominio.ganaderia.RebanoLocal;
import org.example.dominio.persistencia.GanadoEntity;
import org.example.dominio.persistencia.GanadoRepositoryLocal;
import org.example.dominio.persistencia.IGanadoRepository;
import org.example.dominio.persistencia.IPlantaRepository;
import org.example.dominio.persistencia.PlantaEntity;
import org.example.dominio.persistencia.PlantaRepositoryLocal;
import org.example.dominio.persistencia.db.H2Database;
import org.example.dominio.persistencia.db.IDatabase;
import org.example.dominio.persistencia.db.MySQLDatabase;
import org.example.interfaces.ICultivo;
import org.example.interfaces.IRebano;
import org.example.service.CultivoService;
import org.example.service.RebanoService;

public class Factory {
    private Factory() {
    }

    public static IDatabase getPlantaDatabase() {
        return H2Database.getH2Database();
    }

    public static IDatabase getGanadoDatabase() {
        return MySQLDatabase.getMySQLDatabase();
    }

    public static IPlantaRepository getPlantaRepository() {
        return PlantaRepositoryLocal.getPlantaRepositoryLocal();
    }

    public static IGanadoRepository getGanadoRepository() {
        return GanadoRepositoryLocal.getGanadoRepositoryLocal();
    }

    public static ICultivo getCultivo() {
        return CultivoLocal.getCultivoLocal();
    }

    public static IRebano getRebano() {
        return RebanoLocal.getRebanoLocal();
    }

    public static Planta getPlanta(String nombre, double crecimiento) {
        return new Planta(nombre, crecimiento);
    }

    public static Ganado getGanado(String nombre, double peso) {
        return new Ganado(nombre, peso);
    }

    public static PlantaDTO getPlantaDTO(String nombre, double crecimiento) {
        return new PlantaDTO(nombre, crecimiento);
    }

    public static GanadoDTO getGanadoDTO(String nombre, double peso) {
        return new GanadoDTO(nombre, peso);
    }

    public static PlantaEntity getPlantaEntity(Long id, String nombre, double crecimiento) {
        return new PlantaEntity(id, nombre, crecimiento);
    }

    public static GanadoEntity getGanadoEntity(Long id, String nombre, double peso) {
        return new GanadoEntity(id, nombre, peso);
    }

    public static CultivoService getCultivoService() {
        return CultivoService.getCultivoService();
    }

    public static RebanoService getRebanoService() {
        return RebanoService.getRebanoService();
    }
}