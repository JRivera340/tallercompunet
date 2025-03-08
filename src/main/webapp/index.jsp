<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio - TallerSpring</title>

    <!-- CSS embebido -->
    <style>
        /* Fuente moderna desde Google Fonts */
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

        header {
            background: linear-gradient(45deg, #007bff, #00d4ff);
            color: #fff;
            padding: 20px;
            text-align: center;
            margin-bottom: 20px;
            border-radius: 8px;
        }

        h1, h2, h3 {
            margin-bottom: 20px;
            text-align: center;
        }

        ul {
            list-style-type: none;
            margin: 20px auto;
            padding: 0;
            width: 300px;
        }

        li {
            margin: 10px 0;
            text-align: center;
        }

        li a {
            display: inline-block;
            background: linear-gradient(45deg, #007bff, #00d4ff);
            color: #fff;
            text-decoration: none;
            padding: 10px 15px;
            border-radius: 5px;
            transition: background 0.3s ease;
        }

        li a:hover {
            background: linear-gradient(45deg, #0056b3, #00a8cc);
        }

        /* Tablas */
        table {
            width: 90%;
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

        /* Formularios */
        form {
            margin: 20px auto;
            max-width: 400px;
            text-align: center;
        }

        form input[type="text"],
        form input[type="number"],
        form input[type="password"] {
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

        .message {
            text-align: center;
            margin: 20px;
            font-size: 1.1rem;
        }
    </style>

</head>
<body>
<header>
    <h1>Bienvenido al sistema de gestión de vehículos y conductores</h1>
</header>

<ul>
    <li><a href="listVehicles">Listar vehículos</a></li>
    <li><a href="listDrivers">Listar conductores</a></li>
    <li><a href="addVehicle.jsp">Agregar vehículo</a></li>
    <li><a href="addDriver.jsp">Agregar conductor</a></li>
    <li><a href="searchVehicle.jsp">Buscar vehículo</a></li>
    <li><a href="deleteVehicle.jsp">Eliminar vehículo</a></li>
    <li><a href="searchDriverVehicles.jsp">Buscar vehículos de un conductor</a></li>
</ul>
</body>
</html>
