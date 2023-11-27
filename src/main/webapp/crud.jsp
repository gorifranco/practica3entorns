<jsp:useBean id="producte" scope="request" type="com.example.practica3desplegaments.models.Producte"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html  xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Crud</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-6">
            <h4 class="text-center">Editar Producte</h4>
            <form method="post">
                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" name="nom" id="nom" th:value="${producte != null ? producte.nom : ''}"/>
                </div>
                <div class="form-group">
                    <label for="desc">Descripció</label>
                    <input type="text" class="form-control" name="desc" id="desc" value="${producte.descripcio}"/>
                </div>
                <div class="form-group">
                    <label for="preu">Preu</label>
                    <input type="text" class="form-control" name="preu" id="preu" value="${producte.preu}"/>
                </div>
                <div class="form-group">
                    <label for="categories">Categoria</label>
                    <select name="categoria" class="form-control" id="categories">
                        <jsp:include page="/Categories?cat=${producte.categoria}"/>
                    </select>
                </div>
                <div class="form-group">
                    <c:if()c>
                    <input type="submit" class="btn btn-success" value="Guardar Producte"/>
                </div>
            </form>
            <br/>
            <a href="botiga.jsp">Veure Productes</a>
        </div>
    </div>
</div>
</body>
</html>