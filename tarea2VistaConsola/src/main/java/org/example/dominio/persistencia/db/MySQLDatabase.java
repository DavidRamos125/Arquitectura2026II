package org.example.dominio.persistencia.db;

import org.example.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements IDatabase {
    private static MySQLDatabase instance;
    private static final String URL = Properties.getProperty("db.mysql.url");
    private static final String USER = Properties.getProperty("db.mysql.user");
    private static final String PASSWORD = Properties.getProperty("db.mysql.password");

    private Connection connection;

    private MySQLDatabase() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL no encontrado", e);
        }
    }

    public static MySQLDatabase getMySQLDatabase() {
        if (instance == null) {
            instance = new MySQLDatabase();
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
            throw new RuntimeException("Error al conectar con MySQL", e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexion MySQL", e);
        }
    }
}