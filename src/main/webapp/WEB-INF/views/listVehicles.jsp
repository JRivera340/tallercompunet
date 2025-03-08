<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Lista de Vehículos</title>
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
            width: 90%;
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
<h1>Lista de Vehículos</h1>
<table>
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
    <%      }
    } else { %>
    <tr>
        <td colspan="4">No hay vehículos registrados.</td>
    </tr>
    <% } %>
</table>
<br>
<a href="<%= request.getContextPath() %>/index.jsp">Volver al inicio</a>
</body>
</html>
