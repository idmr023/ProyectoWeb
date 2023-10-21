<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Estiulo propio -->
        <link rel="stylesheet" href="../css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container">
              <a class="navbar-brand" href="index.jsp"><img src="img/image 1.png"></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <a class="nav-link" href="index.jsp">Principal</a>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Clientes</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="pag_RegCliente.jsp">Registrar Cliente</a></li>
                      <li><a class="dropdown-item" href="Control?opc=1">Listar Clientes</a></li>
                      <li><a class="dropdown-item" href="pag_FiltraCliente.jsp">Filtrar Clientes</a></li>
                    </ul>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Alquileres</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="pagAlquilerRegistrar.jsp">Registrar Alquiler </a></li>
                      <li><a class="dropdown-item" href="Control?opc=7">Listar Alquileres</a></li>
                      <li><a class="dropdown-item" href="pagAlquilerFiltrar.jsp">Filtrar Alquileres</a></li>
                    </ul>
                  </li>
                  <a class="nav-link" href="reportes.jsp">Habitaciones</a>
                  <a class="nav-link" href="#">Pagos</a>
                  <a class="nav-link" href="index_admin.jsp">Reportes</a>
                </div>
              </div>
            </div>
        </nav>
        
    </body>
</html>
