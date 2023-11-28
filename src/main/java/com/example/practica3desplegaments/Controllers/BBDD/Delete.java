package com.example.practica3desplegaments.Controllers.BBDD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Delete")
public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        Connection c = Connexio.getConnection();
        String sql = "delete from productes where id = ?";
        int result = -1;
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = -1;
        }
        if (result > 0) {
            pw.println("<html><head></head><body><script>alert('Producte borrat correctament!'); window.location.href='botiga.jsp';</script></body></html>");
        } else {
            pw.println("<p>Error borrant el producte</p>");
        }
    }
}
