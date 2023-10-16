<%@page import="modelo.JCMail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
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

    <%@ include file="./layout/menu.jsp" %>
    
    <% 
        JCMail mail = new JCMail();
        
        String correo = request.getParameter("dni");
        String dni = request.getParameter("pswd");
        String mensaje = "";

        Connection connection = null;
        Statement statement = null;

        try {
            // Realiza la conexión a la base de datos (debes proporcionar la URL, el nombre de usuario y la contraseña correctos)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdHotelAntares", "root@localhost", "");

            // Consulta para verificar el usuario y contraseña
            String query = "SELECT * FROM empleados WHERE emp_codigo = ?, emp_correo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, dni);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                mail.setTo(correo);
            } else {
                mensaje = "No funcioonó";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    %>
    
    
    <body>
        <section class="banner">
            <div class="banner__texto">
                <h1>Hotel Antares</h1>
                <p>Este hotel te ofrece las mejores habitaciones y suites</p>
                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                    <button class="banner__botones-login btn btn-primary">Login</button>
                    <button type="button" class="btn btn-success">A</button>
                    <button class="banner__botones-register btn btn-primary">Register</button>
                    <p><%=mensaje%></p>
                </div>
            </div>
        </section>
        
        <div class="form-container">
            <form method="POST" class="form" id="formulario__login">
                <h3>Iniciar sesión</h3>
                <hr>                 

                <label for="dni">Correo</label>
                <input type="text" id="dni" name="dni"  maxlength="20"><br>

                <label for="pswd">DNI</label>
                <input type="password" id="password" name="pswd"> <br><br>
                <button class="btn btn-light">Iniciar sesión</button>
            </form>
        </div>
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
                        <img src="https://thumbs.dreamstime.com/b/muestra-del-estacionamiento-del-coche-31904937.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Estacionamiento</h5>
                            <p class="card-text">Amplio estacionamiento seguro y conveniente para nuestros huéspedes, con acceso directo al hotel.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://png.pngtree.com/png-clipart/20230423/original/pngtree-laundry-line-icon-png-image_9076949.png" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Lavadería</h5>
                            <p class="card-text">Servicio de lavandería y tintorería disponible para mantener tu ropa fresca y limpia durante tu estancia.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://cdn1.vectorstock.com/i/1000x1000/70/25/woman-skin-care-spa-vector-23927025.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Spa</h5>
                            <p class="card-text">Nuestro lujoso spa te brinda la oportunidad de relajarte y rejuvenecer con tratamientos de bienestar y masajes terapéuticos.</p>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src="https://cdn5.vectorstock.com/i/1000x1000/51/34/gym-sport-bodybuilding-logo-or-label-strong-man-vector-20535134.jpg" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">Gimnasio</h5>
                            <p class="card-text">Mantén tu rutina de ejercicios en nuestro gimnasio bien equipado con equipos modernos y un ambiente motivador.</p>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <footer>
            <%@ include file="./layout/footer.jsp" %>
        </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
</html>
