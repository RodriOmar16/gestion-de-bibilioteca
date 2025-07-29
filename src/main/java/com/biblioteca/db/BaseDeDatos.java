package com.biblioteca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
    private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto1"; // ⚠️ Reemplazá con el nombre real de tu base
    private static final String USUARIO = "postgres"; // o el usuario que tengas configurado
    private static final String CONTRASENA = "postgres"; // reemplazá por tu contraseña real

    private static Connection conexion;

    // ✅ Devuelve la conexión (la crea si no existe)
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("✅ Conexión exitosa a PostgreSQL.");
            } catch (SQLException e) {
                System.err.println("❌ Error al conectar a la base de datos:");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // 🔌 Cierra la conexión cuando ya no se usa
    public static void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("🔌 Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}