<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- boostrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="//cdn.muicss.com/mui-0.10.3/css/mui.min.css" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/estilos_generales.css">
        <title>Página principal</title>
        
</head>
<html>

        <%@ include file="menu.jsp" %>
    
    <body>
        <section class="banner">
            <div class="banner__texto">
                <h1>Hotel Antares</h1>
                <p>Este hotel te ofrece las mejores habitaciones y suites</p>
                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                    <button class="banner__botones-login btn btn-primary">Login</button>
                    <button type="button" class="btn btn-success">A</button>
                    <button class="banner__botones-register btn btn-primary">Register</button>
                  </div>
            </div>
        </section>
        <br>
            
        <section class="container card mb-3" id="contenedor_info">
            <div class="row g-0">
                <div class="col-md-4">
                  <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                      <div class="carousel-item active" data-bs-interval="3000">
                          <img src="img/4.jpg" class="d-block w-100" alt="...">
                      </div>
                      <div class="carousel-item" data-bs-interval="3000">
                          <img src="img/5.jpg" class="d-block w-100" alt="...">
                      </div>
                      <div class="carousel-item">
                          <img src="img/6.jpg" class="d-block w-100" alt="...">
                      </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
                          data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
                          data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                  </button>
                </div>
              </div>
                
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">Nuestras habitaciones</h5>
                <p class="card-text">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magni est veritatis nihil sed error qui hic 
                  recusandae cumque rerum unde delectus asperiores natus nulla velit, quibusdam tenetur repellendus
                  quod eaque. Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, natus consequuntur
                  esse molestias rerum error porro nisi, libero dolor tempora sed sequi soluta ratione impedit enim.
                  Quae quaerat veritatis molestias.<br>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magni est veritatis nihil sed error qui hic
                  recusandae cumque rerum unde delectus asperiores natus nulla velit, quibusdam tenetur repellendus
                  quod eaque.</p>
                <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                </div>
              </div>
                
            </div>
        </section>

        <section class="servicios container d-flex flex-wrap justify-content-between">
            <h2 class="seccion w-100">Servicios</h2>
            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="img/servicios_wifi.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Wifi</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural
                                lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-body-secondary">Last updated 3 mins
                                    ago</small></p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="img/servicios_atencion.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Atencion 24h</h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural
                                lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-body-secondary">Last updated 3 mins
                                    ago</small></p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="img/servicios_limpieza.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Limpieza </h5>
                            <p class="card-text">This is a wider card with supporting text below as a natural
                                lead-in to
                                additional content. This content is a little bit longer.</p>
                            <p class="card-text"><small class="text-body-secondary">Last updated 3 mins
                                    ago</small></p>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
</html>
