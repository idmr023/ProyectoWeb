

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

        <h1>Editar Cliente</h1>

        <form action="control" method="post">
            <input type="hidden" name="opc" value="3">
            
            <div class="form-group row">
                <label for="inputPassword5" class="col-sm-2 col-form-label" value="<%=c.getCli_dni()%>"></label>
                <div class="col-sm-10">
                    <input type="number" class="form-control"  aria-describedby="dniCondicional" name="dni" required>
                </div>
                <small id="dniCondicional" class="form-text text-muted">
                  El DNI debe ser de 8 dígitos
                </small>
            </div>
            
            <div class="form-group row">
              <label for="nombre" class="col-sm-2 col-form-label" value="<%=c.getCli_nombre()%>"></label>
              <div class="col-sm-10">
                <input type="text" name="nombre" class="form-control" id="nombre" required>
              </div>
            </div>
            
            <div class="form-group row">
              <label for="apellido" class="col-sm-2 col-form-label" value="<%=c.getCli_apellido()%>"></label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="apellido" name="apellido" required>
              </div>
            </div>
                
            <div class="form-group row">
              <label class="col-form-label col-sm-2 pt-0" for="genero_cli" value="<%=c.getCli_genero()%>"></label>
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
                <label for="telefono" class="col-sm-2 col-form-label" value="<%=c.getCli_celular()%>"></label>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="telefono" name="celular">
                </div>
            </div>
            
            <div class="form-group row">
                <label for="dias" class="col-sm-2 col-form-label" value="<%=c.getCli_num_dias()%>"></label>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="dias" name="dias">
                </div>
            </div>    
            
            <div class="form-group row">
                <label for="fecha" class="col-sm-2 col-form-label" value="<%=c.getCli_fech_reg()%>"></label>
                <div class="col-sm-10">
                  <input type="date" class="form-control" id="fecha" name="fecha">
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-form-label col-sm-2 pt-0" for="tipo_cliente" value ="<%=c.getCli_tipo_habitacion()%>">Seleccionar Tipo de Habitación</label>
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
            
            <table class="table table-bordered">
                <tr>
                    <td>DNI:</td>
                    <td><input type="number" name="dni" value="" readonly></td>
                </tr>
                <tr>
                    <td>Nombres:</td>
                    <td><input type="text" name="nombre" value=""></td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellido" value=""></td>
                </tr>
                <tr>
                    <td><label for="genero_cli">Seleccionar Género:</label></td>
                    <td>
                        <select id="genero_cli" name="genero" value="">
                            <option value="">--Elegir--</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                            <option value="B">Binario</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Celular:</td>
                    <td><input type="number" name="celular" value=""></td>
                </tr>
                <tr>
                    <td>Número de días:</td>
                    <td><input type="number" name="dias"value="" ></td>
                </tr>
                <tr>
                    <td>Fecha de Registro:</td>
                    <td><input type="date" name="fecha" value=""></td>
                </tr>
                <tr>
                    <td><label for="tipo_cliente">Seleccionar Tipo de Habitación:</label></td>
                    <td>
                        <select id="tipo_cliente" name="tipo"value="">
                            <option value="">--Elegir--</option>
                            <option value="Estandar">Estándar</option>
                            <option value="Suite">Suite</option>
                            <option value="Deluxe">Deluxe</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
