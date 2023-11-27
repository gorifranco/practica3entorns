package com.example.practica3desplegaments.Controllers.BBDD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/javascript");
        int id = Integer.parseInt(req.getParameter("id"));

        Connection c = Connexio.getConnection();
        String sql = "delete from productes where id = ?";
        int resultat = -1;
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            resultat = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            resultat = e.getErrorCode();
        }
        if(resultat > 0){
            pw.println("<script>alert('Producte borrat amb èxit!')</script>");
        }else{
            pw.println("<script>alert('No s'ha pogut borrar el producte')</script>");
        }
    }
}
