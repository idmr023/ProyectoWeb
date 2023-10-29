package controlador;

import dao.daoGrafico;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Habitacion;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class SrvtlGrafico extends HttpServlet {

    daoGrafico dGraf = new daoGrafico();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            
        try {
            int year = Integer.parseInt(request.getParameter("tan"));
            String tipo=request.getParameter("tipo");
            OutputStream flujo=response.getOutputStream();
            if(tipo.equals("pie")) ChartUtilities.writeChartAsJPEG(flujo,torta(year), 700,500 );
            if(tipo.equals("bar")) ChartUtilities.writeChartAsJPEG(flujo,barra(year), 700,500 );
            if(tipo.equals("line")) ChartUtilities.writeChartAsJPEG(flujo,lineal(year), 700,500 );
            else throw new IllegalArgumentException("Tipo de gráfico no válido: " + tipo);
        } catch (Exception e) {
            e.printStackTrace();
            // Opcionalmente, puedes mostrar un mensaje de error en la respuesta
            response.getWriter().write("Error al generar el gráfico: " + e.getMessage());
        }
    }
    
    JFreeChart torta(int an){
         DefaultPieDataset ds=new DefaultPieDataset();
         for(Habitacion x:dGraf.LisVenta(an)){
             ds.setValue(x.Lmes(),x.getTotal());
         }
          //graficar en memoria
        JFreeChart gf=ChartFactory.createPieChart3D("año "+an, ds);
        return gf;
      }
        JFreeChart barra(int an){
         DefaultCategoryDataset ds=new DefaultCategoryDataset();
         for(Habitacion x:dGraf.LisVenta(an)){
             ds.setValue(x.getTotal(),"venta",x.Lmes());
         }
          //graficar en memoria
        JFreeChart gf=ChartFactory.createBarChart3D("año "+an, "mes", "venta", ds);
        return gf;
      }
        JFreeChart lineal(int an){
         DefaultCategoryDataset ds=new DefaultCategoryDataset();
         for(Habitacion x:dGraf.LisVenta(an)){
             ds.setValue(x.getTotal(),"venta",x.Lmes());
         }
          //graficar en memoria
        JFreeChart gf=ChartFactory.createLineChart3D("año "+an, "mes", "venta", ds);
        return gf;
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
