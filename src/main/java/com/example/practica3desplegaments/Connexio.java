package com.example.practica3desplegaments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connexio {

    private static final String USERNAME = "debianp1gori";
    private static final String PASSWORD = "DebianP1Gori";
    private static final int PORT = 3306;
    private static final String SERVER = "192.168.216.99";
    private static final String DATABASE = "biblioteca";

    private static Connection conn = null;

    // Método para establecer la conexión a la base de datos
    private static void connect() {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE;
            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            System.out.println("Connection success.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println("Failed connecting to the database.");
        }
    }

    protected static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return conn;
    }

    protected static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Failed closing the connection.");
            }
        }
    }

    public static List<String[]> getAllProducts() {

        Connection c = Connexio.getConnection();
        String sql = "select productes.nom, descripció, preu, categories.nom as cat from productes \n" +
                "inner join categories on categories.id = productes.categoria_id";

        List<String[]> result = new ArrayList<>();

        try (Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] fila = new String[4];
                fila[0] = rs.getString("nom");
                fila[1] = rs.getString("descripció");
                fila[2] = Float.toString(rs.getFloat("preu"));
                fila[3] = rs.getString("cat");
                result.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexio.closeConnection();
        }
        return result;
    }
}