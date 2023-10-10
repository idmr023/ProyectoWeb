<%@page import="modelo.*"%>
<%@page import="controlador.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Panel de control</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/dashboard.css">
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link rel="icon" type="image/png" href="./img/logo.jpg"/>
    </head>

    <header>
        <%@ include file="menu.jsp" %>
    </header>

    <body>

        <%
            Negocio obj = new Negocio();
        %>

        <div class="contenedor__principal">

            <div class="container__informacion">
                <main class="main">
                    <div class="card text-white bg-dark mb-3" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Último movimiento realizado:</h5>
                            <p class="card-text"><?php echo "Pago por ".$row['concepto']." el día ".$row['fecha']?></i></p>
                        </div>
                    </div>

                    <div class="card bg-light mb-3" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Último movimiento</h5>
                            <p class="card-text"><?php echo "S/.".$row['importe']?></p>
                        </div>
                    </div>

                    <div class="card text-white bg-info mb-3" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Bienvenido a su cuenta,</h5>
                            <p class="card-text"><?php echo $row['nombre']?></p>
                        </div>
                    </div>

                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">Beneficios Canjeados</h5>
                            <p class="card-text">Gracias por su preferencia</p>
                        </div>
                    </div>
                    <?php } ?>
                </main> 

                <table class="table table-dark">
                    <h1>Datos de usuario</h1>
                    <a href="pag_RegCliente.jsp">Registrar un Nuevo Cliente</a>
                    <br>
                    <a href="pag_FiltraCliente.jsp">Buscar Cliente por Nombre</a>
                    <thead>
                        <tr>
                            <th scope="col">DNI</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Sexo</th>
                            <th scope="col">Celular</th>
                            <th scope="col">Dias</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Habitación</th>
                            <th scope="col">Importe</th>
                            <th scope="col">Modificar</th>
                            <th scope="col">Eliminar</th>
                        </tr>
                    </thead>


                    <tbody>        
                        <%
                            for (Cliente x : obj.listadoCliente()) {

                                x.tipo_hab();
                                out.print("<tr><td>" + x.getCli_dni() + "<td>" + x.getCli_nombre() + "<td>" + x.getCli_apellido() + "<td>" + x.getCli_genero() + "<td>" + x.getCli_celular() + "<td>" + x.getCli_num_dias() + "<td>" + x.getCli_fech_reg() + "<td>" + x.getCli_tipo_habitacion() + "<td>" + x.precio()
                                );

                        %>
                    <td><a href="control?opc=2&nro=<%=x.getCli_dni()%>">Edit</td>
                    <td><a href="control?opc=4&nro=<%=x.getCli_dni()%>">Delet</td>

                    <%
                        }
                    %>
                    </tbody>
                </table>           

            </div>

        </div>

        <?php require('layout/footer.php'); ?>
    </body>

</html>