package org.example.dominio.persistencia;

import org.example.dominio.ganaderia.Ganado;
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

public class GanadoRepositoryLocal implements IGanadoRepository {
    private static GanadoRepositoryLocal instance;
    private final IDatabase database;

    private GanadoRepositoryLocal() {
        this.database = Factory.getGanadoDatabase();
    }

    public static GanadoRepositoryLocal getGanadoRepositoryLocal() {
        if (instance == null) {
            instance = new GanadoRepositoryLocal();
        }
        return instance;
    }

    @Override
    public void save(Ganado ganado) {
        String sql = "INSERT INTO ganado (nombre, peso) VALUES (?, ?)";
        GanadoEntity entity = GanadoEntity.fromGanado(ganado);
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getNombre());
            ps.setDouble(2, entity.getPeso());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el ganado", e);
        }
    }

    @Override
    public Optional<Ganado> findById(Long id) {
        String sql = "SELECT id, nombre, peso FROM ganado WHERE id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapear(rs).toGanado());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el ganado por id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Ganado> findAll() {
        String sql = "SELECT id, nombre, peso FROM ganado";
        List<Ganado> ganados = new ArrayList<>();
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ganados.add(mapear(rs).toGanado());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar el ganado", e);
        }
        return ganados;
    }

    @Override
    public void update(Ganado ganado) {
        String sql = "UPDATE ganado SET peso = ? WHERE nombre = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, ganado.getPeso());
            ps.setString(2, ganado.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el ganado", e);
        }
    }

    @Override
    public void delete(Ganado ganado) {
        String sql = "DELETE FROM ganado WHERE nombre = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ganado.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el ganado", e);
        }
    }

    private GanadoEntity mapear(ResultSet rs) throws SQLException {
        return Factory.getGanadoEntity(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getDouble("peso")
        );
    }
}