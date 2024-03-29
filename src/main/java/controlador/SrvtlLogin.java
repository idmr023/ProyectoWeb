package controlador;

import dao.daoEmpleados;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Empleado;
import modelo.SendEmail;

public class SrvtlLogin extends HttpServlet {

    daoEmpleados dEmp = new daoEmpleados();
    Empleado emp = new Empleado();
    SendEmail sm = new SendEmail();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            String accion = request.getParameter("accion");
            int r;
            if (accion != null && accion.equals("Ingresar")) {
                String correo = request.getParameter("correo");
                String pswd = request.getParameter("pswd");
                emp.setEmp_correo(correo);
                emp.setPswd(pswd);

                r = dEmp.validar(emp);

                emp = new Empleado(correo, pswd);
                boolean test = sm.sendEmail(emp);
                System.out.println(r);
                if (r == 1 && test) {
                    HttpSession session = request.getSession();
                    session.setAttribute("correo", emp.getEmp_correo());
                    session.setAttribute("pswd", emp.getPswd());
                    request.getRequestDispatcher("index_clientes.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("index_clientes.jsp");
            }
        }
        
        if (op == 2) {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("correo");
            sesion.removeAttribute("pswd");
            response.sendRedirect("index.jsp");
        }

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
