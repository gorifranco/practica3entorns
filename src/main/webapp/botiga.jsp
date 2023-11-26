<%@ page import="com.example.practica3desplegaments.Consulta" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<table>
    <thead>
    <tr>
        <td>
            NOM
        </td>
        <td>
            DESCRIPCIÓ
        </td>
        <td>
            PREU
        </td>
        <td>
            CATEGORIA
        </td>
    </tr>
    </thead>
    <tbody>
        <%=new Consulta()%>
    </tbody>
</table>
</body>
</html>