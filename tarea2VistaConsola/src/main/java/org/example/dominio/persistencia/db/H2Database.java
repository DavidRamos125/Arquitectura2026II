package org.example.dominio.persistencia.db;

import org.example.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Database implements IDatabase {
    private static H2Database instance;
    private static final String URL = Properties.getProperty("db.h2.url");
    private static final String USER = Properties.getProperty("db.h2.user");
    private static final String PASSWORD = Properties.getProperty("db.h2.password");

    private Connection connection;

    private H2Database() {
    }

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver H2 no encontrado", e);
        }
    }

    public static H2Database getH2Database() {
        if (instance == null) {
            instance = new H2Database();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con H2", e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion H2", e);
        }
    }
}