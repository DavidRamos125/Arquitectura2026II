package org.example.persistencia;

import org.example.dominio.persistencia.db.MySQLDatabase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MySQLConnectionTest {

    private static final MySQLDatabase mysql = MySQLDatabase.getMySQLDatabase();

    @Test
    void debeConectarseYRetornarConexionValida() throws SQLException {
        Connection conn = mysql.getConnection();
        assertNotNull(conn, "La conexion no debe ser null");
        assertFalse(conn.isClosed(), "La conexion debe estar abierta");

        DatabaseMetaData meta = conn.getMetaData();
        System.out.println("Conectado a: " + meta.getDatabaseProductName() + " " + meta.getDatabaseProductVersion());
    }

    @AfterAll
    static void cerrarConexion() {
        mysql.closeConnection();
    }
}