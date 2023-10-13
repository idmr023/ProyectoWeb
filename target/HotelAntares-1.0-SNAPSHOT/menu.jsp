<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Estiulo propio -->
        <link rel="stylesheet" href="css/style.css">
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
                  <a class="nav-link" href="index.jsp">Index</a>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Clientes
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="Control?opc=1">Listar Clientes</a></li>
                      <li><a class="dropdown-item" href="pag_RegCliente.jsp">Registrar Clientes</a></li>
                    </ul>
                  </li>
                  <a class="nav-link" href="reportes.jsp">Reporte</a>
                  <a class="nav-link">Disabled</a>
                  <a class="nav-link" href="#">Pricing</a>
                  <a class="nav-link">Disabled</a>
                  <a class="nav-link" href="#">Pricing</a>
                  <a class="nav-link">Disabled</a>
                </div>
              </div>
            </div>
        </nav>
        
    </body>
</html>
