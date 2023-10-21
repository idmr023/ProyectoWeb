<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*,java.util.*,dao.Negocio" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HA - Listado de Alquileres</title>        
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
    </head>
    
    
    <%@ include file="./layout/menu.jsp" %>
    <body>
    <center>
        <%
            HttpSession ses = request.getSession();
            String nuevoAlq = "";
            if (ses.getAttribute("nuevoAlq") != null) {
                nuevoAlq = (String) ses.getAttribute("nuevoAlq");
                out.print("<h3 class="+"text-black"+">Se ha creado con exito el alquiler "+nuevoAlq+"</h3>");
            }
            List<Alquiler> lista = (ArrayList<Alquiler>) ses.getAttribute("listaAlq");
            int nreg = lista.size();
            int tampag = 10;
            int inicio = 0, fin;
            int npag = (nreg / tampag) + 1;
        %>
        <h2 class="text-cyan">Listado de Alquileres</h2>        
        <a href="pagAlquilerRegistrar.jsp">Registrar Alquiler</a><br>
        <a href="pagAlquilerFiltrar.jsp">Filtrar Alquiler</a><br>

        <%
            for (int i = 1; i <= npag; i++) {
        %>
        <a href="pagAlquilerListar.jsp?pag=<%=i%>">&nbsp;<%=i%>&nbsp;</a>
        <%
            }
            int pagact = 0;
            if (request.getParameter("pag") != null) {
                pagact = Integer.parseInt(request.getParameter("pag"));
                if (pagact == 1) {
                    inicio = 0;
                } else {
                    inicio = (pagact - 1) * tampag;
                }
            }
            fin = inicio + tampag;
            if (fin > nreg)
                fin = nreg;
        %>

        <table class="table table-hover">
            <thead>
                <tr class="text-white bg-black">
                    <th>Cod. Alquiler<th>Cod. Habitacion<th>DNI Cliente<th>Fecha Ingreso<th>Fecha Salida<th>Cod. Empleado<th>Estado<th>Modificar
            </thead>
            <%
                for (int i = inicio; i < fin; i++) {
                    Alquiler a = lista.get(i);
                    out.print("<tr><td>" + a.getAlq_codigo() + "<td>" + a.getHab_codigo() + "<td>" + a.getCli_dni() + "<td>" + a.getAlq_fechaIngreso() + "<td>" + a.getAlq_fechaSalida() + "<td>" + a.getEmp_codigo() + "<td>" + a.getAlq_estado());
                    if(a.getAlq_estado().equals("Finalizado")){
                        out.print("<td>No Disponible");
                    }else{
                        out.print("<td><a href="+"Control?opc=9&cod="+a.getAlq_codigo()+"><img src="+"botones/Edit.gif"+" height="+"20"+" width="+"20"+" class="+"center-block"+"></a>");
                    }    
                }
            %>    
        </table>
    </center>    
    </body>
</html>