<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="modelo.Habitacion,dao.Negocio" %>
<html>
    <script src="./js/Chart.min.js" type="text/javascript"></script>
  <style>
    .container {
      width: 70%;
      margin: 15px auto;
    }
    body {
      text-align: center;
      color: green;
    }
    h2 {
      text-align: center;
      font-family: "Verdana", sans-serif;
      font-size: 30px;
    }
  </style>
  <body>
      <%
         Negocio  obj=new Negocio();
         String label="",data="";
         int an=Integer.parseInt(request.getParameter("tan"));
         String tipo=request.getParameter("tipo");
         for(Habitacion x:obj.LisVenta(an)){
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
   
    <div class="container">
      <h2>CLIENTES POR MES EN EL AÑO :<%=an%></h2>
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
            label: "cantidad de clientes",
            data: [<%=data%>],
            backgroundColor: <%=color%>,
          },
         
        ],
      },
    });
  </script>
</html>