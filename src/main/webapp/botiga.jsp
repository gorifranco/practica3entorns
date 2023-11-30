<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Botiga Gori</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<br/>
<div class="container m-auto" style="width: 700px">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col" class="text-center">
                NOM
            </th>
            <th scope="col" class="text-center">
                DESCRIPCIÓ
            </th>
            <th scope="col" class="text-center">
                PREU
            </th>
            <th scope="col" class="text-center">
                CATEGORIA
            </th>
            <th scope="col" class="text-center">
                ACCIÓ
            </th>
        </tr>
        </thead>
        <tbody>
        <jsp:include page="Consulta"/>
        </tbody>
    </table>
    <div style="margin: auto; text-align: center">
        <a href="WEB-INF/insertar.jsp" class="btn btn-primary mt-5">Afegir Producte</a>
    </div>
</div>
</body>
</html>