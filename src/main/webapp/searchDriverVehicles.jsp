<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, co.icesi.tallerspring.model.Driver, co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Buscar Vehículos de un Conductor</title>
</head>
<body>
<h1>Buscar Vehículos de un Conductor</h1>
<form action="searchDriverVehicles" method="post">
    Número de Identificación del Conductor: <input type="text" name="numIdentificacion"><br>
    <input type="submit" value="Buscar">
</form>

<hr>

<h2>Resultados:</h2>
<%
    Driver driver = (Driver) request.getAttribute("driver");
    if (driver != null) {
%>
<p>Conductor: <%= driver.getNombre() %> - Cargo: <%= driver.getCargo() %></p>
<table border="1">
    <tr>
        <th>Placa</th>
        <th>Marca</th>
        <th>Modelo</th>
    </tr>
    <%
        List<Vehicle> vehicles = driver.getVehicles();
        if (vehicles != null && !vehicles.isEmpty()) {
            for (Vehicle vehicle : vehicles) {
    %>
    <tr>
        <td><%= vehicle.getPlaca() %></td>
        <td><%= vehicle.getMarca() %></td>
        <td><%= vehicle.getModelo() %></td>
    </tr>
    <%      }
    } else { %>
    <tr>
        <td colspan="3">Este conductor no tiene vehículos registrados.</td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No se encontró información del conductor.</p>
<% } %>

<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
