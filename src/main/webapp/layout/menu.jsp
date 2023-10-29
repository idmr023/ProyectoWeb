<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/47427cc084.js" crossorigin="anonymous"></script>
    
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if(session.getAttribute("correo") == null && session.getAttribute("pswd") == null){
                response.sendRedirect("index.jsp");
            }
            %>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container">
              <a class="navbar-brand" href="index_clientes.jsp"><img src="img/image 1.png"></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Clientes</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="pag_RegCliente.jsp">Registrar Cliente</a></li>
                      <li><a class="dropdown-item" href="SrvtlCliente?opc=1">Listar Clientes</a></li>
                      <li><a class="dropdown-item" href="pag_FiltraCliente.jsp">Filtrar Clientes</a></li>
                    </ul>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Alquileres</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="pagAlquilerRegistrar.jsp">Registrar Alquiler </a></li>
                      <li><a class="dropdown-item" href="SrvtlAlquiler?opc=7">Listar Alquileres</a></li>
                      <li><a class="dropdown-item" href="pagAlquilerFiltrar.jsp">Filtrar Alquileres</a></li>
                    </ul>
                  </li>
                  <a class="nav-link" href="#">Habitaciones</a>
                  <a class="nav-link" href="#">Pagos</a>
                  <a class="nav-link" href="index_admin.jsp">Reportes</a>
                </div>
              </div>
              
              <form action="SrvtlLogin">
                  <input type="hidden" name="opc" value="2">
                  <button  class="btn btn-primary" >
                      <span class="fa-solid fa-arrow-right-from-bracket"></span> Cerrar sesión
                  </button>
              </form>
              
            </div>
        </nav>
        
    </body>
</html>
