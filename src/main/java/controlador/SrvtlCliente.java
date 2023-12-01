package controlador;

import com.google.gson.Gson;
import dao.daoCliente;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.*;

public class SrvtlCliente extends HttpServlet {

    daoCliente dCli = new daoCliente();
    Cliente c = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op = Integer.parseInt(request.getParameter("opc"));
        //Clientes
        if (op == 1) agregarCli(request, response);
        if (op == 2) editaCli(request, response);
        if (op == 3) actualizarCli(request, response);
        if (op == 4) EliminarCli(request, response);
        if (op == 5) flitrarCli(request, response);
        if (op == 6) grabar(request, response);
    }
    
    protected void agregarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //String clientName = dCli.nom_cli(request.getParameter("nombre"));
        
        
        c.setCli_dni(request.getParameter("dni"));
        c.setApellido(request.getParameter("apellido"));
        c.setNombre(request.getParameter("nombre"));
        c.setSexo(request.getParameter("genero"));
        c.setCelular(request.getParameter("celular"));
        String avatarUrl = "https://ui-avatars.com/api/?name=" + request.getParameter("nombre");
        c.setUrl_foto(avatarUrl);
        
        dCli.agregarCli(c);

        String pag = "/pag_ListCliente.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void flitrarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("consulta");
        PrintWriter out = response.getWriter();
        Gson gs = new Gson();
        out.print(gs.toJson(dCli.flitrarCli(nom)));
    }
    
        protected void editaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nro = Integer.parseInt(request.getParameter("nro"));
        request.setAttribute("dato", dCli.consultaCli(nro));
        String pag = "/pag_EditCliente.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void actualizarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        c.setCli_dni(request.getParameter("dni"));
        c.setApellido(request.getParameter("apellido"));
        c.setNombre(request.getParameter("nombre"));
        c.setSexo(request.getParameter("cbSexo"));
        c.setCelular(request.getParameter("celular"));
        dCli.modificarCli(c);

        String pag = "/pag_ListCliente.jsp";

        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void EliminarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));

        dCli.eliminarCli(nro);

        String pag = "/pag_ListCliente.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }
    
    protected void grabar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ses.setAttribute("cliente", c);
        Cliente cli = (Cliente) ses.getAttribute("cliente");
        String cad="DNI:"+cli.getCli_dni()+"<br/> Apellido :"+cli.getApellido()+"Nombre" + cli.getNombre();
        response.sendRedirect("SrvtlCodigoQR?texto="+cad); 
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
