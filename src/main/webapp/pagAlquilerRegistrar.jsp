<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*, rutinas.Fechas, dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HA - Agregar Alquiler</title>
        <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <%@ include file="./layout/menu.jsp" %>

    <body>
        <%
            Fechas f = new Fechas();
            String minIngreso = f.minFechaIngreso();
            String minSalida = f.minFechaSalida();

            daoEmpleados emp = new daoEmpleados();
            daoHabitacion hab = new daoHabitacion();
            
            String tipo = "";

            if (request.getParameter("cbTipo") != null) {
                tipo = request.getParameter("cbTipo");
            }
        %>   
        <h2>Registrar Alquiler</h2>
        <div class="container">
            <h3>Datos del alquiler</h3>
            <form id="formTipoHabitacion">
                <div class="form-group">
                    <label class="control-label" for="id_tipo">Tipo</label>
                    <select class="form-control" id="id_tipo" name="cbTipo" onchange="submit()">
                        <option disabled selected>Seleccionar</option>
                        <%
                            String[] tipos = {"Simple", "Doble", "Matrimonial"};
                            for (int i = 0; i < tipos.length; i++) {
                                if (tipo.equals(tipos[i])) {
                                    out.print("<option value=" + tipos[i] + " selected>" + tipos[i] + "</option>");
                                } else {
                                    out.print("<option value=" + tipos[i] + ">" + tipos[i] + "</option>");
                                }
                            }
                        %>
                    </select>
                </div>
            </form><!--formulario tipo habitacion--> 
            <form action="SrvtlAlquiler" id="formRegAlquiler">
                <div class="container__alquiler">
                    <input type="hidden" name="opc" value="6">
                    <div class="form-group">
                        <label class="control-label" for="id_habitacion">Habitación</label>
                        <select class="form-control" id="id_habitacion" name="cbHabitacion" required>
                            <option disabled selected>Seleccionar</option>
                            <%
                                for (habitacion x : hab.listarHabDispo()) {
                                    if (x.getHab_tipo().equals(tipo)) {
                                        out.print("<option value=" + x.getHab_codigo() + ">" + x.getHab_codigo() + "</option>");
                                    }
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_ingreso">Fecha de Ingreso</label>
                        <input type="date" class="form-control" id="id_ingreso" name="ingreso" min="<%=minIngreso%>" value="<%=minIngreso%>" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_salida">Fecha de Salida</label>
                        <input type="date" class="form-control" id="id_salida" name="salida" min="<%=minSalida%>" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_empleado">Empleado que registra el alquiler</label>
                        <select class="form-control" id="id_empleado" name="cbEmpleado" required>
                            <option disabled selected>Seleccionar</option>
                            <% 
                                for(Empleado x:emp.listarEmp()){
                                    String empleado = x.getEmp_codigo() + " - " + x.nomApe();
                                    out.print("<option value="+x.getEmp_codigo()+">"+ empleado +"</option>");
                                }
                            %>
                        </select>
                    </div>
                </div><!-- datos alquiler -->
                <div class="container__cliente">
                    <h3>Datos del cliente</h3>
                    <div class="form-group">
                        <label class="control-label" for="id_dni">DNI</label>
                        <input class="form-control" type="text" id="id_dni" name="dni" placeholder="DNI" maxlength="8" required>  
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_apellido">Apellido</label>
                        <input class="form-control" type="text" id="id_apellido" name="apellido" placeholder="Apellido" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_nombre">Nombre</label>
                        <input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Nombre" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_sexo">Sexo</label>
                        <select class="form-control" id="id_sexo" name="cbSexo" required>
                            <option disabled selected>Seleccionar</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="id_celular">Celular</label>
                        <input class="form-control" type="text" id="id_celular" name="celular" placeholder="Celular" maxlength="9" required>
                    </div>
                </div><!<!-- datos cliente -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">REGISTRAR</button>
                </div><!-- boton -->
            </form>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#formRegAlquiler').bootstrapValidator({
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
        
    </body>
    <%@ include file="./layout/footer.jsp" %>
</html>
