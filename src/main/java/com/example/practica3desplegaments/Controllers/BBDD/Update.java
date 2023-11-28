package com.example.practica3desplegaments.Controllers.BBDD;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Update")
public class Update extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String descripcio = request.getParameter("desc");
        String preu = request.getParameter("preu");
        String categoria = request.getParameter("cat");

        int result = Connexio.update(id, nom, descripcio, preu, categoria);
        if (result > 0) {
            out.println("<script>alert('Producte guardat correctament!'); window.location.href='botiga.jsp';</script>");
        } else {
            out.println("<p>Error durant el guardat</p>");
        }

    }
}
