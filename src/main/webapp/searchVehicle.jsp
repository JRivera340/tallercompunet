<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Buscar Vehículo</title>
</head>
<body>
<h1>Buscar Vehículo por Placa</h1>

<!-- El formulario envía al servlet "searchVehicle" -->
<form action="<%= request.getContextPath() %>/searchVehicle" method="post">
    Placa: <input type="text" name="placa" required><br>
    <input type="submit" value="Buscar">
</form>

<hr>
<h2>Resultado:</h2>
<%
    // Si el servlet puso "vehicle" en el request, lo mostramos
    Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
    // Verificamos si el usuario ya envió el formulario (placa != null)
    String placaParam = request.getParameter("placa");

    if (vehicle != null) {
%>
<table border="1">
    <tr>
        <th>Placa</th>
        <th>Marca</th>
        <th>Modelo</th>
    </tr>
    <tr>
        <td><%= vehicle.getPlaca() %></td>
        <td><%= vehicle.getMarca() %></td>
        <td><%= vehicle.getModelo() %></td>
    </tr>
</table>
<%
} else if (placaParam != null) {
    // Significa que el usuario envió el form, pero 'vehicle' es null
%>
<p>No se encontró vehículo con la placa <b><%= placaParam %></b>.</p>
<%
    }
    // Si placaParam == null, es la primera vez que se abre el JSP, sin buscar todavía
%>

<br>
<a href="<%= request.getContextPath() %>/index.jsp">Volver al inicio</a>
</body>
</html>
