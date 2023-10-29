<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HA - Filtrar Alquiler</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/filtrarAlquiler.js" type="text/javascript"></script>
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
                location = "SrvtlAlquiler?opc=9&cod=" + cod;
            }
        </script>
        
    <%@ include file="./layout/footer.jsp" %>
    </body>
</html>