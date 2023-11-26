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
    <jsp:include page="/Consulta"/>
    </tbody>
</table>
<div><</div>
</body>
</html>