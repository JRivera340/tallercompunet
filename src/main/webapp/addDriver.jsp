<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Conductor</title>
</head>
<body>
<h1>Agregar Nuevo Conductor</h1>
<form action="addDriver" method="post">
    ID: <input type="text" name="id"><br>
    Nombre: <input type="text" name="name"><br>
    Cargo: <input type="text" name="cargo"><br>
    Tipo de Identificación: <input type="number" name="tipoIdentificacion"><br>
    Número de Identificación: <input type="text" name="numIdentificacion"><br>
    <input type="submit" value="Agregar Conductor">
</form>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
