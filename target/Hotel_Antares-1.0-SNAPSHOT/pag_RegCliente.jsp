<%@page import="controlador.Negocio"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://kit.fontawesome.com/47427cc084.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/estilos_generales.css">
        <link rel="stylesheet" href="css/filtra_cliente.css">
    </head>
    
    <%@ include file="menu.jsp" %>
    <body>
        
    <div class="container">
        <h1><center>Registro</center></h1>
        
        <form action="control" method="post">
            <input type="hidden" name="opc" value="1">
            <div class="form-group row">
                <label for="inputPassword5" class="col-sm-2 col-form-label">DNI</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control"  aria-describedby="dniCondicional" name="dni" required>
                </div>
                <small id="dniCondicional" class="form-text text-muted">
                  El DNI debe ser de 8 dígitos
                </small>
            </div>
            
            <div class="form-group row">
              <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
              <div class="col-sm-10">
                <input type="text" name="nombre" class="form-control" id="nombre" required>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="apellido" name="apellido" required>
              </div>
            </div>
                
            <div class="form-group row">
              <label class="col-form-label col-sm-2 pt-0" for="genero_cli">Seleccionar género</label>
              <div class="col-sm-10">
                <select id="genero_cli" name="genero">
                    <option value="">--Elegir--</option>
                    <option value="M">Masculino</option>
                    <option value="F">Femenino</option>
                    <option value="B">Binario</option>
                </select>
              </div>
            </div>
          
            <div class="form-group row">
                <label for="telefono" class="col-sm-2 col-form-label">Número telefónico</label>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="telefono" name="celular">
                </div>
            </div>
            
            <div class="form-group row">
                <label for="dias" class="col-sm-2 col-form-label">Número de días</label>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="dias" name="dias">
                </div>
            </div>    
            
            <div class="form-group row">
                <label for="fecha" class="col-sm-2 col-form-label">Número de días</label>
                <div class="col-sm-10">
                  <input type="date" class="form-control" id="fecha" name="fecha">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-form-label col-sm-2 pt-0" for="tipo_cliente">Seleccionar Tipo de Habitación</label>
                <div class="col-sm-10">
                  <select id="tipo_cliente" name="tipo">
                        <option value="">--Elegir--</option>
                        <option value="Estandar">Estándar</option>
                        <option value="Suite">Suite</option>
                        <option value="Deluxe">Deluxe</option
                  </select>
                <button colspan="2" type="submit" class="btn btn-primary" value="Enviar">Enviar</button>
                </div>
                                
            </div>
        </form>
    </div>
            
</body>
</html>