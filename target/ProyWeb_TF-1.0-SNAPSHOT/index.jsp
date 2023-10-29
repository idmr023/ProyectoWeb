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
                <h1>Hotel antares </h1>
                <p class="par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt neque 
                expedita atque eveniet <br> quis nesciunt. Quos nulla vero consequuntur, fugit nemo ad delectus 
                <br> a quae totam ipsa illum minus laudantium?</p>
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