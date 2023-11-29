package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import modelo.*;
import dao.*;

//xhtml
import javax.faces.bean.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped

public class Control extends HttpServlet implements Serializable {
    
    private daoHabitacion obj = new daoHabitacion();  
    
    private Cliente c = new Cliente();

    //xhtml
    private List<habitacion> listarHabitaciones;
    private habitacion hab;
    private String texto;

    @PostConstruct
    public void init() {
        listarHabitaciones = new daoHabitacion().listarHab();

    }

    public void grabar() {

        new daoHabitacion().agregarHab(hab);
        listarHabitaciones = new daoHabitacion().listarHab();
        hab = new habitacion();
    }

    public void filtra() {
        listarHabitaciones = new daoHabitacion().filtraHabitacion(texto);
    }

    public Control() {
        texto = "";
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

    public daoHabitacion getObj() {
        return obj;
    }

    public void setObj(daoHabitacion obj) {
        this.obj = obj;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public List<habitacion> getListarHabitaciones() {
        return listarHabitaciones;
    }

    public void setListarHabitaciones(List<habitacion> listarHabitaciones) {
        this.listarHabitaciones = listarHabitaciones;
    }

    public habitacion getHab() {
        return hab;
    }

    public void setHab(habitacion hab) {
        this.hab = hab;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
