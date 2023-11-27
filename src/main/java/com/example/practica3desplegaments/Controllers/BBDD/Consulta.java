package com.example.practica3desplegaments.Controllers.BBDD;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.practica3desplegaments.models.Producte;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Consulta", value = "/Consulta")
public class Consulta extends HttpServlet {
    private List<Producte> array;

    public void init() {
        Connection c = Connexio.getConnection();
        String sql = "select id, productes.nom as nom, descripció, preu, categories.nom as cat from productes \n" +
                "inner join categories on categories.id = productes.categoria_id";
        array = new ArrayList<>();

        try (Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
            if(rs == null) throw new SQLException("Error durant la consulta");
            while (rs.next()) {
                Producte p = new Producte();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescripcio(rs.getString("descripció"));
                p.setPreu(rs.getFloat("preu"));
                p.setCategoria(rs.getString("cat"));
                array.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexio.closeConnection();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        array.forEach(a -> out.println("<tr>" +
                "<td>" + a.getNom() + "</td>" +
                "<td> " + a.getDescripcio() + "</td>" +
                "<td>" + a.getPreu() +"</td>" +
                "<td>" + a.getCategoria() + "</td>" +
                "<td><a href='Editar?id="+ a.getId() +"></a></td>" +
                "<td><a href='Delete?id=" + a.getId() + "'>Eliminar</a></td>" +
                "</tr>"));
    }
}