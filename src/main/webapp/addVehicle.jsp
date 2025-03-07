<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Vehículo</title>
</head>
<body>
<h1>Agregar Nuevo Vehículo</h1>
<form action="addVehicle" method="post">
    ID: <input type="text" name="id"><br>
    Placa: <input type="text" name="placa"><br>
    Cilindraje: <input type="text" name="cilindraje"><br>
    Tipo Combustible: <input type="text" name="tipoCombustible"><br>
    Número Motor: <input type="text" name="numeroMotor"><br>
    Marca: <input type="text" name="marca"><br>
    Modelo: <input type="number" name="modelo"><br>
    ID del Conductor: <input type="text" name="conductorId"><br>
    <input type="submit" value="Agregar Vehículo">
</form>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
