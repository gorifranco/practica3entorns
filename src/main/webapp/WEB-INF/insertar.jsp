<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instertar producte</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid" style="margin: auto; width: 800px">
    <div class="row-fluid">
        <h4 class="text-center">Editar Producte</h4>
        <form method="post" action="Insert">
            <div class="form-group mb-3">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" name="nom" id="nom"/>
            </div>
            <div class="form-group mb-3">
                <label for="desc">Descripció</label>
                <input type="text" class="form-control" name="desc" id="desc"/>
            </div>
            <div class="form-group mb-3">
                <label for="preu">Preu</label>
                <input type="text" class="form-control" name="preu" id="preu"/>
            </div>
            <div class="form-group  mb-5">
                <label for="categories">Categoria</label>
                <select name="cat" class="form-control" id="categories">
                    <jsp:include page="/Categories"/>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-success" value="Guardar Producte"/>
            </div>
        </form>
        <br/>
        <a href="../botiga.jsp">Veure Productes</a>
    </div>
</div>
</body>
</html>