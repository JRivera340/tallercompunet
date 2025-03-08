<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Conductor</title>
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
    <h1>Agregar Nuevo Conductor</h1>
</header>
<form action="addDriver" method="post">
    ID: <input type="text" name="id" required><br>
    Nombre: <input type="text" name="name" required><br>
    Cargo: <input type="text" name="cargo" required><br>
    Tipo de Identificación: <input type="number" name="tipoIdentificacion" required><br>
    Número de Identificación: <input type="text" name="numIdentificacion" required><br>
    <input type="submit" value="Agregar Conductor">
</form>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
