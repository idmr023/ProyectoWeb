
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- boostrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="//cdn.muicss.com/mui-0.10.3/css/mui.min.css" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link rel="stylesheet" href="./css/estilos_registrarse.css">
        <title>Página principal</title>
        
</head>
<html>

        <%@ include file="menu.jsp" %>
    
    <body>
        
        <div id="main">

    <div class="content">
        <div>
            <h1>Hotel <br><span>Antares</span></h1>
            <p class="par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt neque 
            expedita atque eveniet <br> quis nesciunt. Quos nulla vero consequuntur, fugit nemo ad delectus 
            <br> a quae totam ipsa illum minus laudantium?</p>
        </div>
        
        <div class="form-container">
                
                <form action="./in.php" method="POST" id="formulario__login">
                    <h3>Iniciar sesión</h3>
                    <hr>                 

                    <label for="dni">DNI</label>
                    <input type="number" id="dni" name="dni"  maxlength="8"><br>

                    <select class="form-select" aria-label="Default select example" id="selectOption">
                        <option selected>Seleccione su rango</option>
                        <option value="1">Usuario</option>
                        <option value="2">Administrador</option>
                    </select>

                    <label for="pswd">Contraseña</label>
                    <input type="password" id="password" name="pswd"><br><br>
                    <button class="boton btnn" type="button" onclick="redireccionamiento()">Iniciar sesión</button>
                </form>

                <script>
                    function redireccionamiento() {
                        let opcion = document.getElementById('selectOption').value;
                        switch (opcion) {
                            case '1':
                                location.href = './index_clientes.jsp';
                                break;
                            case '2':
                                location.href = './index_admin.jsp';
                                break;
                            default:
                                alert('Seleccione un rango válido');
                        }
                    }
                </script>
                        
                <form action="./php/insertar.php" method="POST">
                    <h3>¡Registrese y sea parte de la mejor banca del país!</h3>
            
                    <label for="nombre">Nombres:</label>
                    <input type="text" id="nombre" name="nombre" required><br>
            
                    <label for="apellido">Apellidos:</label>
                    <input type="text" id="apellido" name="apellido" required><br>
            
                    <label for="correo">Correo:</label>
                    <input type="email" id="correo" name="correo" required><br>
            
                    <label for="dni">DNI:</label>
                    <input type="number" id="dni" name="dni" required pattern="[0-9]+" maxlength="8"><br>
            
                    <label for="fec_nac">Fecha de nacimiento:</label>
                    <input type="date" id="fec_nac" name="fec_nac" required><br>
            
                    <label for="contraseña">Contraseña:</label>
                    <input type="password" id="contraseña" name="contraseña" required minlength="8"><br>
            
                    <input type="checkbox" name="tyc"> Acepto los términos y condiciones<br>
            
                    <button href="./php/insertar.php">Registarse</button>
                </form>
            
        </div>
    </div>

</div>
        
        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
</html>
