package com.example.practica3desplegaments.Controllers;

import com.example.practica3desplegaments.Controllers.BBDD.Connexio;
import com.example.practica3desplegaments.models.Producte;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Editar  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Producte p = Connexio.getProducteFromId(id);
        request.setAttribute("producte", p);
        RequestDispatcher dispatcher = request.getRequestDispatcher("crud.jsp");
        dispatcher.forward(request, response);
    }
}
