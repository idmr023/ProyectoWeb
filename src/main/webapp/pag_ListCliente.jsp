<%@page import="modelo.*"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Panel de control</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/dashboard.css">
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link rel="icon" type="image/png" href="./img/logo.jpg"/>
    </head>
    
    <%@ include file="./layout/menu.jsp" %>

    <body>

        <%
            daoCliente obj = new daoCliente();
        %>

        <div class="contenedor__principal">

            <div class="container__informacion">
                <table class="table table-dark">
                    <h1>Datos de usuario</h1>
                    <a href="pag_RegCliente.jsp">Registrar un Nuevo Cliente</a>
                    <br>
                    <a href="pag_FiltraCliente.jsp">Filtrar Cliente por DNI</a>
                    <thead>
                        <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Sexo</th>
                            <th scope="col">Celular</th>
                            <th scope="col">Editar</th>
                            <th scope="col">Modificar</th>

                        </tr>
                    </thead>


                    <tbody>        
                        <%
                            for (Cliente x : obj.listarCli()) {

                                out.print("<tr><td>" + x.getCli_dni() + "<td>" + x.getApellido() + "<td>" + x.getNombre() + "<td>" + x.getSexo() + "<td>" + x.getCelular()
                                );

                        %>
                    <td><a href="SrvtlCliente?opc=2&nro=<%=x.getCli_dni()%>">Editar</td>
                    <td><a href="SrvtlCliente?opc=4&nro=<%=x.getCli_dni()%>">Eliminar</td>

                    <%
                        }
                    %>
                    </tbody>
                </table>           

            </div>

        </div>

        
            <%@ include file="./layout/footer.jsp" %>
    </body>

</html>