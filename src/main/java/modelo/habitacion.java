package modelo;

import java.sql.Date;

public class habitacion {
    private String id_varchar;
    private int num_dias;
    private Date fec_ingreso;
    private Date fec_salida;   
    private String tipo_hab;
    private double total;
    private int mes;
    
    public String Lmes(){
        String meses[]={"","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Set","Oct","Nov","Dic"};
        return meses[mes];
    }

    public String getId_varchar() {
        return id_varchar;
    }

    public void setId_varchar(String id_varchar) {
        this.id_varchar = id_varchar;
    }

    public int getNum_dias() {
        return num_dias;
    }

    public void setNum_dias(int num_dias) {
        this.num_dias = num_dias;
    }

    public Date getFec_ingreso() {
        return fec_ingreso;
    }

    public void setFec_ingreso(Date fec_ingreso) {
        this.fec_ingreso = fec_ingreso;
    }

    public Date getFec_salida() {
        return fec_salida;
    }

    public void setFec_salida(Date fec_salida) {
        this.fec_salida = fec_salida;
    }

    public String getTipo_hab() {
        return tipo_hab;
    }

    public void setTipo_hab(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
}
