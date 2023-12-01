package modelo;

public class Pago {
    private String pa_codigo;
    private String pa_fecha;
    private String cli_dni;
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

    public String getCli_dni() {
        return cli_dni;
    }

    public void setCli_dni(String cli_dni) {
        this.cli_dni = cli_dni;
    }
    
}
