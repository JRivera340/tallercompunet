<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, co.icesi.tallerspring.model.Driver" %>
<html>
<head>
    <title>Lista de Conductores</title>
</head>
<body>
<h1>Lista de Conductores</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cargo</th>
    </tr>
    <%
        List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
        if (drivers != null) {
            for (Driver driver : drivers) {
    %>
    <tr>
        <td><%= driver.getId() %></td>
        <td><%= driver.getNombre() %></td>
        <td><%= driver.getCargo() %></td>
    </tr>
    <%  }
    } else { %>
    <tr>
        <td colspan="3">No hay conductores registrados.</td>
    </tr>
    <% } %>
</table>
<br>
<a href="../../index.jsp">Volver al inicio</a>
</body>
</html>
