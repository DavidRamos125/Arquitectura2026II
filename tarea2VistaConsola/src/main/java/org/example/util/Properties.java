package org.example.util;

import java.io.IOException;
import java.io.InputStream;

public class Properties {
    private static final java.util.Properties props = new java.util.Properties();

    static {
        try (InputStream is = Properties.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (is == null) {
                throw new RuntimeException("No se encontro resources/application.properties");
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer resources/application.properties", e);
        }
    }

    public static String getProperty(String property) {
        return props.getProperty(property);
    }
}