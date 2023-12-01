package controlador;

import modelo.*;
import dao.*;
import javax.faces.bean.*;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped

public class control implements Serializable {
    
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
        String habNuevo = new daoHabitacion().agregarHab(hab);
        listarHabitaciones = new daoHabitacion().listarHab();        
        hab = new habitacion();
    }

    public void filtra() {
        listarHabitaciones = new daoHabitacion().filtraHabitacion(texto);
    }

    public control() {
        texto = "";
        hab = new habitacion();
    }

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
