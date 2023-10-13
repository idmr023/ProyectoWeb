package controlador;

import com.google.gson.Gson;
import dao.Negocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import javax.servlet.http.HttpSession;

public class Control extends HttpServlet {

    Negocio obj = new Negocio();
    Cliente c = new Cliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opc"));
        if (op == 1) {
            agregarCli(request, response);
        }
        if (op == 2) {
            editaCli(request, response);
        }
        if (op == 3) {
            actualizarCli(request, response);
        }
        if (op == 4) {
            EliminarCli(request, response);
        }
        if (op == 5) {
            flitrarCli(request, response);
        }
        if (op==6)registrarAlq(request, response);
        if (op==7)listarAlq(request, response);
        if (op==8)filtrarAlq(request, response);
        if (op==9)buscarAlq(request, response);
        if (op==10)modificarAlq(request, response);

    }

    protected void agregarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        c = new Cliente();

        c.setCli_dni(request.getParameter("dni"));
        c.setApellido(request.getParameter("apellido"));
        c.setNombre(request.getParameter("nombre"));
        c.setSexo(request.getParameter("genero"));
        c.setCelular(request.getParameter("celular"));

        obj.agregarCli(c);

        String pag = "/clientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void flitrarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("consulta");
        PrintWriter out = response.getWriter();
        Gson gs = new Gson();
        out.print(gs.toJson(obj.flitrarCli(nom)));
    }
    
        protected void editaCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nro = Integer.parseInt(request.getParameter("nro"));
        request.setAttribute("dato", obj.consultaCli(nro));
        String pag = "/pag_EditCliente.jsp";
        request.getRequestDispatcher(pag).forward(request, response);

    }

    protected void actualizarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();

        c.setCli_dni(request.getParameter("dni"));
        c.setApellido(request.getParameter("apellido"));
        c.setNombre(request.getParameter("nombre"));
        c.setSexo(request.getParameter("genero"));
        c.setCelular(request.getParameter("celular"));
        obj.modificarCli(c);

        String pag = "/clientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);
    }

    protected void EliminarCli(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nro = Integer.parseInt(request.getParameter("nro"));

        obj.eliminarCli(nro);

        String pag = "/clientes.jsp";

        request.getRequestDispatcher(pag).forward(request, response);

    }
    
    protected void registrarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String hab = request.getParameter("cbHabitacion");
        String ingreso = request.getParameter("ingreso");
        String salida = request.getParameter("salida");
        String empleado = request.getParameter("cbEmpleado");
        String dni = request.getParameter("dni");
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("cbSexo");
        String celular = request.getParameter("celular");
        
        Alquiler a = new Alquiler();
        a.setHab_codigo(hab);
        a.setCli_dni(dni);
        a.setAlq_fechaIngreso(ingreso);
        a.setAlq_fechaSalida(salida);
        a.setEmp_codigo(empleado);
        String nuevoAlq = obj.agregarAlq(a);
        
        Cliente busCli = obj.buscarCli(dni);
        if(busCli==null){
            c.setCli_dni(dni);
            c.setApellido(apellido);
            c.setNombre(nombre);
            c.setSexo(sexo);
            c.setCelular(celular);
            obj.agregarCli(c);
        }
        request.setAttribute("nuevoAlq", nuevoAlq);
        listarAlq(request, response);
    }
    
    protected void listarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ses.setAttribute("listaAlq", obj.listarAlq());
        if (request.getParameter("nuevoAlq")!=null){
            String nuevoAlq = request.getParameter("nuevoAlq");
            ses.setAttribute("nuevoAql", nuevoAlq);
        }
        String pag = "/pagAlquilerListar.jsp";        
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void filtrarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dniFiltrar = request.getParameter("consulta");
        PrintWriter out=response.getWriter();
        Gson gs = new Gson();
        out.print(gs.toJson(obj.filtrarAlqCli(dniFiltrar)));
    }
    
    protected void buscarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codBuscar = request.getParameter("cod");
        request.setAttribute("alquiler", obj.buscarAlqCod(codBuscar));
        request.setAttribute("codigo", codBuscar);
        String pag = "/pagAlquilerModificar.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void modificarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoMod = request.getParameter("codigo");
        String salidaMod = request.getParameter("salida");
        String estadoMod = request.getParameter("cbEstado");
        String habitacionMod = request.getParameter("habitacion");
        
        obj.modificarAlq(salidaMod, estadoMod, codigoMod);
        if (estadoMod.equals("Finalizado")){
            obj.liberarHab(habitacionMod);
        }        
        listarAlq(request, response);
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
