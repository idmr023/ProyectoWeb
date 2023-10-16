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
    </head>
    <body>
        <div id="main">
        
            <div class="content">
                <div>
                    <h1>Banco <br><span>Chanchito</span> <br>UTP</h1>
                    <p class="par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt neque 
                    expedita atque eveniet <br> quis nesciunt. Quos nulla vero consequuntur, fugit nemo ad delectus 
                    <br> a quae totam ipsa illum minus laudantium?</p>
                </div>

                <div class="form-container">

                        <form action="./in.php" method="POST" class="form" id="formulario__login">
                            <h3>Iniciar sesión</h3>
                            <hr>                 

                            <label for="dni">DNI</label>
                            <input type="number" id="dni" name="dni"  maxlength="8"><br>

                            <label for="pswd">Contraseña</label>
                            <input type="password" id="password" name="pswd"> <br><br>
                            <button class="boton btnn">Iniciar sesión</button>
                        </form>

                </div>
            </div>
        </div>
        
    </body>
</html>