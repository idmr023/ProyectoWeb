<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h2>Grafico de ventas</h2>
        <form action="Control" target="zona">
            ingrese año :<input name="opc">
            <br><input type="radio" name="tipo" value="bar" onclick="submit()">barra
            <input type="radio" name="tipo" value="pie" onclick="submit()">Circular
            <input type="radio" name="tipo" value="line" onclick="submit()">Lineal
         </form>
        <iframe name="zona" width="100%" height="500"></iframe>
    </center>
    </body>
</html>