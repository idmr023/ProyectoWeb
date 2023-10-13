

<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
            Cliente c = (Cliente) request.getAttribute("dato");
        %>

        <div class="container">
            <h1><center>Registro</center></h1>

            <form action="Control" method="post">
                <input type="hidden" name="opc" value="3">
                <div class="form-group row">
                    <label for="inputPassword5" class="col-sm-2 col-form-label"  >DNI</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control"  aria-describedby="dniCondicional" name="dni"value="<%=c.getCli_dni()%>" readonly>
                    </div>
                    <small id="dniCondicional" class="form-text text-muted">
                        El DNI debe ser de 8 dígitos
                    </small>
                </div>

                <div class="form-group row">
                    <label for="nombre" class="col-sm-2 col-form-label">Apellido</label>
                    <div class="col-sm-10">
                        <input type="text" name="apellido" class="form-control" id="nombre" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="apellido" class="col-sm-2 col-form-label">Nombre</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="apellido" name="nombre" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-form-label col-sm-2 pt-0" for="genero_cli">Seleccionar género</label>
                    <div class="col-sm-10">
                        <select id="genero_cli" name="genero">
                            <option value="">--Elegir--</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>

                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="telefono" class="col-sm-2 col-form-label">Número telefónico</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="telefono" name="celular">
                    </div>
                </div>

                <button colspan="2" type="submit" class="btn btn-primary" value="Enviar">Enviar</button>

            </form>
        </div>

    </body>
</html>
