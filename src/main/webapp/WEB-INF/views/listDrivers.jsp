<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, co.icesi.tallerspring.model.Driver" %>
<html>
<head>
    <title>Lista de Conductores</title>
    <!-- CSS embebido -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background: #f0f2f5;
            font-family: 'Roboto', sans-serif;
            color: #333;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        table th, table td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007bff;
            color: #fff;
            font-weight: 700;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            background: linear-gradient(45deg, #007bff, #00d4ff);
            color: #fff;
            padding: 10px 15px;
            border-radius: 5px;
            transition: background 0.3s ease;
            text-align: center;
        }

        a:hover {
            background: linear-gradient(45deg, #0056b3, #00a8cc);
        }
    </style>
</head>
<body>
<h1>Lista de Conductores</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cargo</th>
        <th>Numero de Identificación</th>
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
        <td><%= driver.getNumIdentificacion() %></td>

    </tr>
    <%      }
    } else { %>
    <tr>
        <td colspan="3">No hay conductores registrados.</td>
    </tr>
    <% } %>
</table>
<br>
<a href="<%= request.getContextPath() %>/index.jsp">Volver al inicio</a>
</body>
</html>
