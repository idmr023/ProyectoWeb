<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" href="css/estilos_generales.css">
        <title>Página principal</title>
        
</head>
<html>

    <%@ include file="./layout/menu.jsp" %>
    
    <body>
        <section class="banner_clientes">
            <div class="banner__texto">
                <h1>Hotel Antares</h1>
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
                <p class="card-text">Equipadas con comodidades modernas y mobiliario elegante, estas habitaciones brindan un hogar lejos del hogar. 
                    Además de las características estándar, como camas cómodas y baños bien equipados, las habitaciones cuentan con áreas de estar adicionales y facilidades para 
                    una estancia prolongada, como kitchenette o cocinas totalmente equipadas, ideales para aquellos que buscan comodidad y flexibilidad durante su tiempo en el hotel.</p>
                </div>
              </div>
                
            </div>
        </section>

        <section class="servicios container d-flex flex-wrap justify-content-between">
            <h2 class="seccion w-100">Servicios</h2>
            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://img.freepik.com/vector-premium/icono-wi-fi-icono-senal-wifi-senal-conexion-inalambrica-internet-ilustracion-vectorial-aislada-sobre-fondo-blanco_192280-968.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Wifi</h5>
                            <p class="card-text">El hotel ofrece limpieza diaria de habitaciones y áreas comunes para mantener un ambiente ordenado y confortable.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://t3.ftcdn.net/jpg/04/09/66/34/360_F_409663489_ZFDzdvS40JPGoqJKvokd2CWyKB4mErzd.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Atencion 24h</h5>
                            <p class="card-text">El equipo de atención al cliente está disponible las 24 horas para responder consultas, resolver problemas y brindar asistencia a los huéspedes en cualquier momento del día o la noche.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://static.vecteezy.com/system/resources/previews/013/259/505/non_2x/cleaning-products-icon-design-free-vector.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Limpieza </h5>
                            <p class="card-text"> Con acceso wifi gratuito en todas las áreas, los huéspedes pueden disfrutar de una conexión de alta velocidad para trabajar, navegar y mantenerse conectados durante su estancia en el hotel.</p>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <%@ include file="./layout/footer.jsp" %>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
</html>
