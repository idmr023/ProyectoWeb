package miServlet;

import com.google.gson.Gson;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//importaciones de clases 
import modelo.*;
import controlador.*;
import java.sql.Date;

@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {

    Negocio obj = new Negocio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            adicionarCli(request, response);
        }
        if (op == 2) {
            editaCli(request, response);
        }
        if (op == 3) {
            actualizaCli(request, response);
        }
        if (op == 4) {
            deletCli(request, response);
        }
        if (op == 5) {
            filCli(request, response);
        }
    }

    protected void adicionarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente c = new Cliente();

        c.setCli_dni(Integer.parseInt(request.getParameter("dni")));
        c.setCli_nombre(request.getParameter("nombre"));
        c.setCli_apellido(request.getParameter("apellido"));
        c.setCli_genero(request.getParameter("genero"));
        c.setCli_celular(Integer.parseInt(request.getParameter("celular")));
        c.setCli_num_dias(Integer.parseInt(request.getParameter("dias")));
        String fechaRegistroStr = request.getParameter("fecha");
        c.setCli_fech_reg(Date.valueOf(fechaRegistroStr));
        c.setCli_tipo_habitacion(request.getParameter("tipo"));
        obj.adicionCli(c);

    }

    protected void editaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nro = Integer.parseInt(request.getParameter("nro"));
        request.setAttribute("dato", obj.consultaCli(nro));
        String pag = "/pag_EditCliente.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void actualizaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();

        c.setCli_dni(Integer.parseInt(request.getParameter("dni")));
        c.setCli_nombre(request.getParameter("nombre"));
        c.setCli_apellido(request.getParameter("apellido"));
        c.setCli_genero(request.getParameter("genero"));
        c.setCli_celular(Integer.parseInt(request.getParameter("celular")));
        c.setCli_num_dias(Integer.parseInt(request.getParameter("celular")));
        String fechaRegistroStr = request.getParameter("fecha");
        c.setCli_fech_reg(Date.valueOf(fechaRegistroStr));
        c.setCli_tipo_habitacion(request.getParameter("tipo"));
        obj.modificaCliente(c);

        String pag = "/clientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void deletCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));

        obj.deletCli(nro);

        String pag = "/clientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }
    
     protected void filCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("consulta");
        PrintWriter out=response.getWriter();
        Gson gs = new Gson();
         out.print(gs.toJson(obj.filCli(nom)));
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
