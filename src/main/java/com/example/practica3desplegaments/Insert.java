package com.example.practica3desplegaments;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Insert")
public class Insert extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nom = request.getParameter("nom");
        String descripcio = request.getParameter("desc");
        String preu = request.getParameter("preu");
        String categoria = request.getParameter("cat");

        int result = Connexio.insert(nom, descripcio, preu, categoria);
            if(result > 0){
                out.print("<p>Producte guardat correctament!</p>");
                request.getRequestDispatcher("botiga.jsp").include(request, response);
            }else{
                out.println("<p>Error durant el guardat</p>");
            }
    }
}
