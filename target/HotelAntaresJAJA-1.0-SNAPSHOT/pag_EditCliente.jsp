

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
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="js/bootstrapValidator.js" type="text/javascript"></script>
    </head>
    
    
    <%@ include file="./layout/menu.jsp" %>
    <body>
        <%
            Cliente c = (Cliente) request.getAttribute("dato");
        %>

        <div class="container">
            <h1><center>Editar Información</center></h1>

            <form action="Control" method="post" id="formEdit">
                <input type="hidden" name="opc" value="3">
                <div class="container__cliente">
                    <h3>Datos del cliente</h3>
                    <div class="form-group">
                        <label class="control-label" for="id_dni">DNI</label>
                        <input class="form-control" type="text" id="id_dni" name="dni" placeholder="DNI" value="<%=c.getCli_dni()%>" readonly>  
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_apellido">Apellido</label>
                        <input class="form-control" type="text" id="id_apellido" name="apellido" placeholder="Apellido" value="<%=c.getApellido()%>" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_nombre">Nombre</label>
                        <input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Nombre" value="<%=c.getNombre()%>" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_sexo">Sexo</label>
                        <select class="form-control" id="id_sexo" name="cbSexo" value="<%=c.getSexo()%>" required>
                            <option disabled selected>Seleccionar</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_celular">Celular</label>
                        <input class="form-control" type="text" id="id_celular" name="celular" placeholder="Celular" maxlength="9" value="<%=c.getCelular()%>" required>
                    </div>
                </div><!<!-- datos cliente -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">REGISTRAR</button>
                </div><!-- boton -->
            </form>
        </div>

    </body>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#formEdit').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    dni: {
                        validators: {
                            notEmpty: {
                                message: 'El dni es un campo obligatorio'
                            },
                            regexp: {
                                regexp: /^[0-9]{8}$/,
                                message: 'Solo numeros, 8 digitos obligatoriamente'
                            }
                        }
                    },
                    apellido: {
                        validators: {
                            notEmpty: {
                                message: 'El apellido es un campo obligatorio'
                            },
                            regexp: {
                                regexp: /^[A-Za-z ñÑ]+$/,
                                message: 'Solo letras o espacios'

                            }
                        }
                    },
                    nombre: {
                        validators: {
                            notEmpty: {
                                message: 'El nombre es un campo obligatorio'
                            },
                            regexp: {
                                regexp: /^[A-Za-z ñÑ]+$/,
                                message: 'Solo letras o espacios'

                            }
                        }
                    },
                    celular: {
                        validators: {
                            notEmpty: {
                                message: 'El celular es un campo obligatorio'
                            },
                            regexp: {
                                regexp: /^[0-9]{9}$/,
                                message: '9 digitos numericos'
                            }
                        }
                    },
                }
            });

            // Validate the form manually
            $('#validateBtn').click(function () {
                $('#formRegAlquiler').bootstrapValidator('validate');
            });
        });
    </script>
</html>
