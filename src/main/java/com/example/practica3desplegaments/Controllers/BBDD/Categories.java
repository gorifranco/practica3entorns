package com.example.practica3desplegaments.Controllers.BBDD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/Categories")
public class Categories extends HttpServlet {
    private ArrayList<String> categories;
    @Override
    public void init() {
        Connection c = Connexio.getConnection();
        String sql = "select nom from categories";
        ResultSet rs = null;

        try (Statement st = c.createStatement()) {
            rs = st.executeQuery(sql);
            if (rs == null) throw new SQLException("Error en la consulta");
            categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(rs.getString("nom"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        Connexio.closeConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw =resp.getWriter();

        if(req.getParameter("cat") == null){
            categories.forEach(item -> pw.println("<option value='" + item +"'>" + item + "</option>"));
        }else {
            for (String item : categories) {
                String frase = "<option value='" + item + "'";
                if (Objects.equals(req.getParameter("cat"), item)) frase += " required='required'>";
                frase += item +"</option>";
                pw.println(frase);
            }
        }
    }
}
