package controlador;

import dao.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import modelo.*;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class SrvltGrafico extends HttpServlet {

    daoGrafico dGraf = new daoGrafico();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if(op==11){
            int year = Integer.parseInt(request.getParameter("tan"));
            String tipo=request.getParameter("tipo");
            OutputStream flujo=response.getOutputStream();
            if(tipo.equals("pie")) ChartUtilities.writeChartAsJPEG(flujo,torta(year), 700,500 );
            if(tipo.equals("bar")) ChartUtilities.writeChartAsJPEG(flujo,barra(year), 700,500 );
            if(tipo.equals("line")) ChartUtilities.writeChartAsJPEG(flujo,lineal(year), 700,500 );
        }
        
    }
    
    JFreeChart torta(int an){
         DefaultPieDataset ds=new DefaultPieDataset();
         for(habitacion x:dGraf.LisVenta(an)){
             ds.setValue(x.Lmes(),x.getTotal());
         }
          //graficar en memoria
        JFreeChart gf=ChartFactory.createPieChart3D("año "+an, ds);
        return gf;
      }
        JFreeChart barra(int an){
         DefaultCategoryDataset ds=new DefaultCategoryDataset();
         for(habitacion x:dGraf.LisVenta(an)){
             ds.setValue(x.getTotal(),"venta",x.Lmes());
         }
          //graficar en memoria
        JFreeChart gf=ChartFactory.createBarChart3D("año "+an, "mes", "venta", ds);
        return gf;
      }
        JFreeChart lineal(int an){
         DefaultCategoryDataset ds=new DefaultCategoryDataset();
         for(habitacion x:dGraf.LisVenta(an)){
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
