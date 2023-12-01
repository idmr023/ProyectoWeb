package controlador;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import modelo.*;
import dao.*;

@ManagedBean
@ViewScoped
public class controlPagos implements Serializable {

    private List<Cliente> lisCli;
    private List<Pago> lisPag;
    private String nombre;
    private List<PagoDetalle> lisDeta;
    private String pago;
    private String texto;
    
    @PostConstruct    
    public void init(){
        lisCli = new daoCliente().listarCli();
    }
    
    public void consultarPagos(Cliente c) {
        nombre = c.nomApe();
        lisPag = new ArrayList<>();
        lisPag = new daoPagos().lisPag(c.getCli_dni());
    }
    
    public void consultaDetalle(Pago p){
        pago = p.getPa_codigo();
        lisDeta = new ArrayList<>();
        lisDeta = new daoPagos().detaPago(pago);
    }
    
    public void filtrarClientes(){
        lisCli = new daoCliente().flitrarCliApe(texto);
    }
    
    public controlPagos(){
        nombre = "";
        pago = "";
        texto = "";
    }

    public List<Cliente> getLisCli() {
        return lisCli;
    }

    public void setLisCli(List<Cliente> lisCli) {
        this.lisCli = lisCli;
    }

    public List<Pago> getLisPag() {
        return lisPag;
    }

    public void setLisPag(List<Pago> lisPag) {
        this.lisPag = lisPag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public List<PagoDetalle> getLisDeta() {
        return lisDeta;
    }

    public void setLisDeta(List<PagoDetalle> lisDeta) {
        this.lisDeta = lisDeta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
        
}
