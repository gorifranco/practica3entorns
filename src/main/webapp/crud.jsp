<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="col-md-6">
      <h4 class="text-center">Agregar Nuevo Empleado</h4>
      <form action="SaveServlet" method="post">
        <div class = "form-group">
          <label for="nom">Nom:</label>
          <input type="text" class="form-control" name="nom" id="nom"/>
        </div>
        <div class="form-group">
          <label for="desc">Descripció</label>
          <input type="text" class="form-control" name="desc" id="desc"/>
        </div>
        <div class="form-group">
          <label for="email">Preu</label>
          <input type="email" class="form-control" name="email" />
        </div>
        <div class="form-group">
          <label for="country">Categoria</label>
          <select name="country" class="form-control">
            <option>India</option>
            <option>Perú</option>
            <option>USA</option>
            <option>UK</option>
            <option>Other</option>
          </select>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success" value="Guardar Empleado" />
        </div>
      </form>

      <br />
      <a href="botiga.jsp">Veure Productes</a>
    </div>
  </div>
</div>
</body>
</html>