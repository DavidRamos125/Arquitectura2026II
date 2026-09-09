package org.example.dominio.persistencia;

import org.example.dominio.agricultura.Planta;
import org.example.dominio.persistencia.db.IDatabase;
import org.example.factory.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlantaRepositoryLocal implements IPlantaRepository {
    private static PlantaRepositoryLocal instance;
    private final IDatabase database;

    private PlantaRepositoryLocal() {
        this.database = Factory.getPlantaDatabase();
        crearTabla();
        insertarDatosPrueba();
    }

    public static PlantaRepositoryLocal getPlantaRepositoryLocal() {
        if (instance == null) {
            instance = new PlantaRepositoryLocal();
        }
        return instance;
    }

    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS planta (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(255) NOT NULL, " +
                "crecimiento DOUBLE NOT NULL)";
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la tabla planta", e);
        }
    }

    private void insertarDatosPrueba() {
        String countSql = "SELECT COUNT(*) FROM planta";
        String insertSql = "INSERT INTO planta (nombre, crecimiento) VALUES (?, ?)";
        try (Connection conn = database.getConnection()) {
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(countSql)) {
                rs.next();
                if (rs.getInt(1) > 0) {
                    return;
                }
            }
            Planta[] prueba = {
                    new Planta("pancho-maiz", 10),
                    new Planta("marta-arroz", 20),
                    new Planta("lucas-yuca", 30),
                    new Planta("pedro-frijol", 40),
                    new Planta("carla-mango", 50)
            };
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                for (Planta p : prueba) {
                    PlantaEntity entity = PlantaEntity.fromPlanta(p);
                    ps.setString(1, entity.getNombre());
                    ps.setDouble(2, entity.getCrecimiento());
                    ps.addBatch();
                }
                ps.executeBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar datos de prueba", e);
        }
    }

    @Override
    public void save(Planta planta) {
        String sql = "INSERT INTO planta (nombre, crecimiento) VALUES (?, ?)";
        PlantaEntity entity = PlantaEntity.fromPlanta(planta);
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getNombre());
            ps.setDouble(2, entity.getCrecimiento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la planta", e);
        }
    }

    @Override
    public Optional<Planta> findById(Long id) {
        String sql = "SELECT id, nombre, crecimiento FROM planta WHERE id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapear(rs).toPlanta());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar la planta por id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Planta> findAll() {
        String sql = "SELECT id, nombre, crecimiento FROM planta";
        List<Planta> plantas = new ArrayList<>();
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                plantas.add(mapear(rs).toPlanta());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar las plantas", e);
        }
        return plantas;
    }

    @Override
    public void update(Planta planta) {
        String sql = "UPDATE planta SET crecimiento = ? WHERE nombre = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, planta.getCrecimiento());
            ps.setString(2, planta.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la planta", e);
        }
    }

    @Override
    public void delete(Planta planta) {
        String sql = "DELETE FROM planta WHERE nombre = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, planta.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la planta", e);
        }
    }

    private PlantaEntity mapear(ResultSet rs) throws SQLException {
        return Factory.getPlantaEntity(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getDouble("crecimiento")
        );
    }
}