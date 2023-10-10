<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://kit.fontawesome.com/47427cc084.js" crossorigin="anonymous"></script>
        <script src="js/filtrar.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/estilos_generales.css">
        <link rel="stylesheet" href="css/filtra_cliente.css">
        <title>JSP Page</title>

    </head>
  
    <%@ include file="menu.jsp" %>
    <br>
    <body style="background-color: var(--soft-grey)">
        
        <div class="container">
            <h2 style="text-align: center;">Filtrar por nombre de cliente</h2>
                <table class="table table-striped"></table>
            <tr>
            <div class="input-group mb-3">
                <input id="txtnom" type="text" class="form-control" placeholder="Nombre del cliente" aria-label="Nombre del cliente" aria-describedby="basic-addon2">
                <div class="input-group-append">
                  <span class="input-group-text" id="basic-addon2"><i class="fa-solid fa-magnifying-glass"></i></span>
                </div>
            </div>
            
            </tr>


            <div id="tablares"></div>
        </div>
        
            <div id="precioContainer"></div>
            
        <script>
            
            function precio(tipo){
                var precio;
                switch (tipo) {
                case "Estandar":
                    precio = 20;
                    break;
                case "Suite":
                    precio = 40;
                    break;
                case "Deluxe":
                    precio = 60;
                    break;
                default:
                    precio = 0;

                }  
                return precio;
            }
            
            
            function pasaSeleccion(dni, nom, ape, sexo, cel, dias, fech, habit) {
                console.log("Datos del cliente seleccionado:");
                console.log("DNI: " + dni);
                console.log("Nombre: " + nom);
                console.log("Apellido: " + ape);
                console.log("Sexo: " + sexo);
                console.log("Celular: " + cel);
                console.log("Días: " + dias);
                console.log("Fecha: " + fech);
                console.log("Habitación: " + habit);
                var precioHabitacion = precio(habit);
                console.log(precioHabitacion);
                var precioContainer = document.getElementById("precioContainer");
                precioContainer.innerHTML = precioHabitacion;
            }
        </script>
    </body>
</html>
