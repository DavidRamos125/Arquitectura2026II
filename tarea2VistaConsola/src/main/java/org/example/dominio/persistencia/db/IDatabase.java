package org.example.dominio.persistencia.db;

import java.sql.Connection;

public interface IDatabase {
    Connection getConnection();
    void closeConnection();
}