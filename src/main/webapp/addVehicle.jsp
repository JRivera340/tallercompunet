<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Vehículo</title>
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

        header {
            background: linear-gradient(45deg, #007bff, #00d4ff);
            color: #fff;
            padding: 20px;
            text-align: center;
            margin-bottom: 20px;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            margin: 20px auto;
            max-width: 400px;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        form input[type="text"],
        form input[type="number"] {
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
            width: 100%;
        }

        form input[type="submit"]:hover {
            background: linear-gradient(45deg, #0056b3, #00a8cc);
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
        }

        a:hover {
            background: linear-gradient(45deg, #0056b3, #00a8cc);
        }
    </style>
</head>
<body>
<header>
    <h1>Agregar Nuevo Vehículo</h1>
</header>
<form action="addVehicle" method="post">
    ID: <input type="text" name="id" required><br>
    Placa: <input type="text" name="placa" required><br>
    Cilindraje: <input type="text" name="cilindraje" required><br>
    Tipo Combustible: <input type="text" name="tipoCombustible" required><br>
    Número Motor: <input type="text" name="numeroMotor" required><br>
    Marca: <input type="text" name="marca" required><br>
    Modelo: <input type="number" name="modelo" required><br>
    Numero de Identificación del Conductor: <input type="text" name="conductorId" required><br>
    <input type="submit" value="Agregar Vehículo">
</form>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
