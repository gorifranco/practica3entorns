package com.example.practica3desplegaments;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "consultaGori", value = "/consulta")
public class Consulta extends HttpServlet {
    private List<String[]> array;

    public void init() {
        array = Connexio.getAllProducts();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            array.forEach(a -> out.println("<tr><td>" + a[0] + "</td><td> " + a[1] + "</td><td>" + a[2] + "</td><td>" + a[3] + "</td></tr>"));

    }

    public void destroy() {
    }
}