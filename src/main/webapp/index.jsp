<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login Admin - Hotel Antares</title>
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link rel="stylesheet" href="./css/estilos_registrarse.css">
        <link rel="icon" type="image/png" href="./img/logo.jpg"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="content">
            <div>
                <h1>SDG - Hotel antares </h1>
                <p class="par">Sistema de control y gestión del Hotel Antares. En la presente página web se pueden listar, editar y eliminar los clientes. De igual forma se puede 
                visualizar las ganancias por mes, las habitaciones registradas y los usuarios que están en ella, entre otros. Inicie sesión con sus credenciales para poder hacer
                uso de estas funciones.</p>
            </div>

            <div class="form-container">

                <form action="SrvtlLogin" method="POST" class="form" id="formulario__login">
                <input type="hidden" name="opc" value="1">

                    <h3>Iniciar sesión</h3>
                    <hr>                

                    <label for="correo">Correo</label> 
                    <input type="email" name="correo"><br>

                    <label for="pswd">Código</label>
                    <input type="password" name="pswd"> <br><br>

                    <button type="submit" class="btn btn-light" name="accion" value="Ingresar">Iniciar sesión</button>
                </form>

            </div>
        </div>
    </body>
</html>