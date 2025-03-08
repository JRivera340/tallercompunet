<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="co.icesi.tallerspring.model.Vehicle" %>
<html>
<head>
    <title>Buscar Vehículo</title>
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

        form {
            margin: 20px auto;
            max-width: 400px;
            text-align: center;
        }

        form input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            background: linear-gradient(45deg, #007bff, #00d4ff);
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        form input[type="submit"]:hover {
            background: linear-gradient(45deg, #0056b3, #00a8cc);
        }

        table {
            width: 60%;
            margin: 20px auto;
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

        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 1.1rem;
        }
    </style>
</head>
<body>
<h1>Buscar Vehículo por Placa</h1>

<!-- El formulario envía al servlet "searchVehicle" -->
<form action="<%= request.getContextPath() %>/searchVehicle" method="post">
    Placa: <input type="text" name="placa" required><br>
    <input type="submit" value="Buscar">
</form>

<hr>
<h2 style="text-align: center;">Resultado:</h2>
<%
    Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
    String placaParam = request.getParameter("placa");

    if (vehicle != null) {
%>
<table>
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
%>
<p class="message">No se encontró vehículo con la placa <b><%= placaParam %></b>.</p>
<%
    }
%>
<br>
<a href="<%= request.getContextPath() %>/index.jsp">Volver al inicio</a>
</body>
</html>
