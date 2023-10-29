package controlador;

import com.google.gson.Gson;
import dao.daoAlquiler;
import dao.daoCliente;
import dao.daoHabitacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Alquiler;
import modelo.Cliente;

public class SrvtlAlquiler extends HttpServlet {

    daoAlquiler dAlq = new daoAlquiler();
    daoHabitacion dHab = new daoHabitacion();
    
    daoCliente dCli = new daoCliente(); 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int op = Integer.parseInt(request.getParameter("opc"));
        if (op==6)registrarAlq(request, response);
        if (op==7)listarAlq(request, response);
        if (op==8)filtrarAlq(request, response);
        if (op==9)buscarAlq(request, response);
        if (op==10)modificarAlq(request, response);
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
        String nuevoAlq = dAlq.agregarAlq(a);
        Cliente c = new Cliente();
        Cliente busCli = dCli.buscarCli(dni);
        if(busCli==null){
            c.setCli_dni(dni);
            c.setApellido(apellido);
            c.setNombre(nombre);
            c.setSexo(sexo);
            c.setCelular(celular);
            dCli.agregarCli(c);
        }
        request.setAttribute("nuevoAlq", nuevoAlq);
        listarAlq(request, response);
    }
    
    protected void listarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ses.setAttribute("listaAlq", dAlq.listarAlq());
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
        out.print(gs.toJson(dAlq.filtrarAlqCli(dniFiltrar)));
    }
    
    protected void buscarAlq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codBuscar = request.getParameter("cod");
        request.setAttribute("alquiler", dAlq.buscarAlqCod(codBuscar));
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
        
        dAlq.modificarAlq(salidaMod, estadoMod, codigoMod);
        if (estadoMod.equals("Finalizado")){
            dHab.liberarHab(habitacionMod);
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
