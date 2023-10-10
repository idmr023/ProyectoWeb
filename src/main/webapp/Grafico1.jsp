<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="modelo.habitacion,controlador.Negocio" %>
<html>
    <script src="./js/Chart.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="./css/admin.css">
    <link rel="stylesheet" href="./css/estilos_generales.css">
  <style>
    body {
      text-align: center;
      color: green;
    }
  </style>
  <body>
      <%
         Negocio  obj=new Negocio();
         String label="",data="";
         int an=Integer.parseInt(request.getParameter("tan"));
         String tipo=request.getParameter("tipo");
         for(habitacion x:obj.LisVenta(an)){
         label =label+"'"+x.Lmes()+"',";
         data=data+x.getTotal()+",";
         }
         if(obj.LisVenta(an).size()>0){
         label=label.substring(0,label.length()-1);
         data=data.substring(0,data.length()-1);
          }
         String color;
         if(tipo.equals("bar")|| tipo.equals("line")){
           color="'rgba(153,205,1,0.6)'";
          }else{
          color="['rgba(153,205,1,0.6)','lightblue','red','orange','peru','green','blue']";
          }



       %>   
   
    <div class="container_graphic">
      <div>
        <canvas id="myChart"></canvas>
      </div>
    </div>
  </body>
  <script>
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "<%=tipo%>",
      data: {
        labels: [<%=label%> ],
        datasets: [
          {
            label: "Ganancia en soles",
            data: [<%=data%>],
            backgroundColor: <%=color%>,
          },
         
        ],
      },
    });
  </script>
</html>