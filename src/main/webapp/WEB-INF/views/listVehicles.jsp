<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Lista de Vehículos</title>
</head>
<body>
<h1>Lista de Vehículos</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Placa</th>
        <th>Marca</th>
        <th>Modelo</th>
    </tr>
    <%
        List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
        if (vehicles != null) {
            for (Vehicle vehicle : vehicles) {
    %>
    <tr>
        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getPlaca() %></td>
        <td><%= vehicle.getMarca() %></td>
        <td><%= vehicle.getModelo() %></td>
    </tr>
    <%  }
    } else { %>
    <tr>
        <td colspan="4">No hay vehículos registrados.</td>
    </tr>
    <% } %>
</table>
<br>
<a href="../../index.jsp">Volver al inicio</a>
</body>
</html>
