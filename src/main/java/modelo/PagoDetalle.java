package modelo;

public class PagoDetalle extends Pago {
    private String paDeta_concepto;
    private int paDeta_dias;

    public String getPaDeta_concepto() {
        return paDeta_concepto;
    }

    public void setPaDeta_concepto(String paDeta_concepto) {
        this.paDeta_concepto = paDeta_concepto;
    }

    public int getPaDeta_dias() {
        return paDeta_dias;
    }

    public void setPaDeta_dias(int paDeta_dias) {
        this.paDeta_dias = paDeta_dias;
    }    
}
