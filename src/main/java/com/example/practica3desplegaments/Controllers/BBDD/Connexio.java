package com.example.practica3desplegaments.Controllers.BBDD;

import com.example.practica3desplegaments.models.Producte;

import java.sql.*;

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

    public static int insert(String name, String description, String preu, String categoria) {

        int result;
        Connection c = Connexio.getConnection();
        String sql = "insert into preoductes(nom, descripció, preu, categoria_id) values (?, ?, ?, ?)";

        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, Double.parseDouble(preu));
            ps.setInt(4, getCategoryId(categoria));

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            result = e.getErrorCode();
        } finally {
            closeConnection();
        }
        return result;
    }

    public static int getCategoryId(String category) {
        int resultat = -1;
        Connection c = Connexio.getConnection();
        String sql = "select id from categoria where nom = ?";
        ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(0, category);
            rs = ps.executeQuery();
            if (rs.next()) resultat = rs.getInt(0);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultat;
    }

    public static int update(int id, String name, String description, String preu, String category) {
        int resultat;
        Connection c = Connexio.getConnection();
        String sql = "update productes set nom = ?, descripció = ?, preu = ?, categoria = ? where id = ?";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(5, id);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, Double.parseDouble(preu));
            ps.setInt(4, getCategoryId(category));
            resultat = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            resultat = e.getErrorCode();
        }
        return resultat;
    }
    public static Producte getProducteFromId(int id){
        Producte p = null;
        Connection c = Connexio.getConnection();
        String sql = "select productes.id as id, productes.nom as nom, descripció, preu, categories.nom as categoria from productes inner join" +
                "categories on categories.id = productes.fk_categoria where productes.id =" + id + ";";
        try(Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            if(rs == null) throw new SQLException("Error en la consulta");
            rs.next();
            p = new Producte();
            p.setId(rs.getInt("id"));
            p.setId(rs.getInt("id"));
            p.setNom(rs.getString("nom"));
            p.setDescripcio(rs.getString("descripció"));
            p.setPreu(rs.getFloat("preu"));
            p.setCategoria(rs.getString("categoria"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}