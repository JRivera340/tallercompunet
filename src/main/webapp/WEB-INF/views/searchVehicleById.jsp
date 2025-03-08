<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Buscar Vehículo por ID</title>
</head>
<body>
<h1>Buscar Vehículo por ID</h1>
<form action="<%= request.getContextPath() %>/searchVehicleById" method="post">
    ID del Vehículo: <input type="text" name="vehicleId" required /><br>
    <input type="submit" value="Buscar" />
</form>
<hr>
<h2>Resultado:</h2>
<%
    Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
    if (vehicle != null) {
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Placa</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Cilindraje</th>
        <th>Tipo de Combustible</th>
        <th>Número de Motor</th>
    </tr>
    <tr>
        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getPlaca() %></td>
        <td><%= vehicle.getMarca() %></td>
        <td><%= vehicle.getModelo() %></td>
        <td><%= vehicle.getCilindraje() %></td>
        <td><%= vehicle.getTipoCombustible() %></td>
        <td><%= vehicle.getNumeroMotor() %></td>
    </tr>
</table>
<%
} else {
%>
<p>No se encontró vehículo con el ID ingresado.</p>
<%
    }
%>
<br>
<a href="<%= request.getContextPath() %>/index.jsp">Volver al inicio</a>
</body>
</html>
