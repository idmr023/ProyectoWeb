package modelo;

public class Pago extends Alquiler {
    private String pa_codigo;
    private String pa_fecha;
    private double pa_total;

    public String getPa_codigo() {
        return pa_codigo;
    }

    public void setPa_codigo(String pa_codigo) {
        this.pa_codigo = pa_codigo;
    }

    public String getPa_fecha() {
        return pa_fecha;
    }

    public void setPa_fecha(String pa_fecha) {
        this.pa_fecha = pa_fecha;
    }

    public double getPa_total() {
        return pa_total;
    }

    public void setPa_total(double pa_total) {
        this.pa_total = pa_total;
    }
    
}
