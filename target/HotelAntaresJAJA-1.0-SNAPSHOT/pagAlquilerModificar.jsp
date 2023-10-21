<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*, dao.Negocio, rutinas.Fechas" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HA - Modificar Alquiler</title>        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrapValidator.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            Negocio obj = new Negocio();
            Alquiler a = (Alquiler) request.getAttribute("alquiler");
            String cod = request.getParameter("codigo");

            Fechas f = new Fechas();
            String minSalida = f.minFechaSalida();
        %>
        <h2>Modificar Alquiler</h2>
        <div class="container">
            <form action="Control" id="formModAlquiler">
                <input type="hidden" name="opc" value="10">
                <div class="form-group">
                    <label class="control-label" for="id_codigo">Codigo</label>
                    <input type="text" class="form-control" id="id_codigo" name="codigo" value="<%=a.getAlq_codigo()%>" readonly>
                </div>
                <input type="hidden" id="id_habitacion" name="habitacion" value="<%=a.getHab_codigo()%>">
                <div class="form-group">
                    <label class="control-label" for="id_salida">Fecha de Salida</label>
                    <input type="date" class="form-control" id="id_salida" name="salida" min="<%=minSalida%>" value="<%=a.getAlq_fechaSalida()%>">
                </div>
                <div class="form-group">
                    <label class="control-label" for="id_estado">Estado</label>
                    <select class="form-control" id="id_estado" name="cbEstado">
                        <option disabled selected>Seleccionar</option>
                        <%
                            String[] estados = {"Activo", "Finalizado"};
                            for (int i = 0; i < estados.length; i++) {
                                if (a.getAlq_estado().equals(estados[i])) {
                                    out.print("<option value=" + estados[i] + " selected>" + estados[i] + "</option>");
                                } else {
                                    out.print("<option value=" + estados[i] + ">" + estados[i] + "</option>");
                                }
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" >GRABAR</button>
                </div><!-- boton -->
            </form>
        </div>        
    </body>
</html>
