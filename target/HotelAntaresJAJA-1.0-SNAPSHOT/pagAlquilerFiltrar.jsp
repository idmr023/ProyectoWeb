<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HA - Filtrar Alquiler</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/filtrarAlquiler.js" type="text/javascript"></script>
    </head>
    
    
    <%@ include file="./layout/menu.jsp" %>
    
    <body>
        <h2>Filtrar alquiler por DNI</h2>
        <a href="pagAlquilerRegistrar.jsp">Registrar Alquiler</a>
        <table class="table table-bordered">
            <tr><td>DNI de Cliente<td><input type="text" id="txtDni" maxlength="8">
        </table>
        <div id="tablares"></div>
        <script>
            function pasaSeleccion(cod) {
                location = "Control?opc=9&cod=" + cod;
            }
        </script>
    </body>
</html>
