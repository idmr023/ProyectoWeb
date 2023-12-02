<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="modelo.*,dao.*" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="./css/admin.css">
        <link rel="stylesheet" href="./css/estilos_generales.css">
        <title>Reportes - Hostal Antares</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.botpress.cloud/webchat/v1/inject.js"></script>
        <script src="https://mediafiles.botpress.cloud/c4eb3145-72c1-427c-ac4b-476536aedc9e/webchat/config.js" defer></script>

    </head>

    <%@ include file="./layout/menu.jsp" %>

    <body id="page-top">
        <a href="Grafico1.jsp"></a>
        <!-- Begin Page Content -->
        <div class="container-fluid">


            <!-- Content Row -->
            <div class="row">
                <%  
                    daoPagos obj1 = new daoPagos();
                    double pag=0,mes=0;
                    for (Pago x : obj1.lisPagAn()) {
                        pag = x.getPa_total();;
                    }
                    if(pag>0){
                    mes=pag/12;
                    }else pag=0;
                    %> 
                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Ganancias (por mes) </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">S/<%=mes%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                        Ganancias (por año)</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">S/<%=pag%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                        <%  
                                    daoGrafico obj = new daoGrafico();
                                    List<habitacion> habitaciones = obj.LisTipo();
                                    double simple1=0,doble1=0,matrimonial1=0;
                                    for (habitacion x : obj.LisTipo()) { //se obtiene la cantidad de habitaciones ocupadas x tipo
                                        simple1 = habitaciones.get(2).getHab_precio();;
                                        doble1 = habitaciones.get(0).getHab_precio();
                                        matrimonial1 = habitaciones.get(1).getHab_precio();
                                    }
                                    double total=0,simple2=0,doble2=0,matrimonial2=0;
                                    for (habitacion x : obj.LisTotalHab()) {
                                        total = x.getHab_precio();;
                                        simple2 = x.getSimple();;
                                        doble2 = x.getDoble();;
                                        matrimonial2 = x.getMatrimonial();
                                    }
                                    double simple=0,doble=0,matrimonial=0;
                                    if(total>0){
                                    total=(double)Math.round(((simple1+doble1+matrimonial1)/total*100)*100)/100;
                                    }
                                    //se calcula el % de ocupacion x tipo
                                    if(simple1>0){
                                    simple=(double)Math.round((simple1/(simple2)*100)*100)/100;
                                    }
                                    if(doble1>0){
                                    doble=(double)Math.round((doble1/(doble2)*100)*100)/100;
                                    }
                                    if(matrimonial1>0){
                                    matrimonial=(double)Math.round((matrimonial1/(matrimonial2)*100)*100)/100;
                                    }
                        %> 
                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Capacidad total
                                    </div>
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-auto">
                                            <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%=total%>%</div>
                                        </div>
                                        <div class="col">
                                            <div class="progress progress-sm mr-2">
                                                <div class="progress-bar bg-info" role="progressbar"
                                                     style="width: <%=total%>%" aria-valuenow="<%=total%>" aria-valuemin="0"
                                                     aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Pending Requests Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                        Alquileres pendientes</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800"><%=simple1+doble1+matrimonial1%></div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-comments fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Content Row -->

            <div class="row  align-items-center ">

                <!-- Area Chart -->
                <div class="col-lg-6">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div
                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Gráfico de ventas por mes según el año 2D.</h6>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <form action="Grafico1.jsp" target="zona" class="">
                                <div class="input-group mb-3 w-25">
                                    <input type="text" class="form-control" placeholder="Ingrese el año" aria-label="Username" aria-describedby="basic-addon1" name="tan">
                                </div>

                                <div class="form-group d-flex align-items-center justify-content-between">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="bar" id="btn1" onclick="submit()">
                                        <label class="form-check-label" for="btn1">Barra</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="pie" id="btn2" checked onclick="submit()">
                                        <label class="form-check-label" for="btn2">Circular
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="line" id="btn3" checked onclick="submit()">
                                        <label class="form-check-label" for="btn3">Lineal
                                        </label>
                                    </div>
                                </div>
                            </form>
                            <iframe class="zona" name="zona"></iframe>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div
                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">Gráfico de ventas por mes según el año 3D.</h6>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <form action="SrvltGrafico" target="zona2" >
                                <input type="hidden" name="opc" value="11">

                                <div class="input-group mb-3 w-25">
                                    <input type="text" class="form-control" placeholder="Ingrese el año" aria-label="Username" aria-describedby="basic-addon1" name="tan">
                                </div>

                                <div class="form-group d-flex align-items-center justify-content-between">
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="bar" id="btn1" onclick="submit()">
                                        <label class="form-check-label" for="btn1">Barra</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="pie" id="btn2" checked onclick="submit()">
                                        <label class="form-check-label" for="btn2">Circular
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="tipo" value="line" id="btn3" checked onclick="submit()">
                                        <label class="form-check-label" for="btn3">Lineal
                                        </label>
                                    </div>
                                </div>
                            </form>
                            <iframe class="zona2" name="zona2"></iframe>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Content Row -->
            <div class="row">

                <!-- Content Column -->
                <div class="col-lg-6 mb-4">

                    <!-- Project Card Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">% de alquiler según el tipo de habitación actualmente</h6>
                        </div>
                        
                        <div class="card-body">
                            <h4 class="small font-weight-bold">Tipo simple <span
                                    class="float-right"><%=simple%>%</span></h4>
                            <div class="progress mb-4">
                                <div class="progress-bar bg-danger" role="progressbar" style="width: <%=simple%>%"
                                     aria-valuenow="<%=simple%>" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <h4 class="small font-weight-bold">Tipo doble <span
                                    class="float-right"><%=doble%>%</span></h4>
                            <div class="progress mb-4">
                                <div class="progress-bar bg-warning" role="progressbar" style="width: <%=doble%>%"
                                     aria-valuenow="<%=doble%>" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <h4 class="small font-weight-bold">Tipo matrimonial <span
                                    class="float-right"><%=matrimonial%>%</span></h4>
                            <div class="progress mb-4">
                                <div class="progress-bar" role="complete" style="width: <%=matrimonial%>%"
                                     aria-valuenow="<%=matrimonial%>" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <%@ include file="./layout/footer.jsp" %>
</body>

</html>