package modelo;

public class habitacion {
    private String hab_codigo;
    private String hab_tipo;
    private double hab_precio;
    private String hab_estado;
    private int mes;
    private double total;
    private double simple;
    private double doble;
    private double matrimonial;

    public habitacion(double hab_precio, double simple, double doble, double matrimonial) {
        this.hab_precio = hab_precio;
        this.simple = simple;
        this.doble = doble;
        this.matrimonial = matrimonial;
    }
    
    
    
    public habitacion() {
    }

    public habitacion(String hab_codigo, String hab_tipo, String hab_estado) {
        this.hab_codigo = hab_codigo;
        this.hab_tipo = hab_tipo;
        this.hab_estado = hab_estado;
    }
    
    
    public String Lmes(){
        String meses[]={"","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Set","Oct","Nov","Dic"};
        return meses[mes];
    }

    public String getHab_codigo() {
        return hab_codigo;
    }

    public void setHab_codigo(String hab_codigo) {
        this.hab_codigo = hab_codigo;
    }

    public String getHab_tipo() {
        return hab_tipo;
    }

    public void setHab_tipo(String hab_tipo) {
        this.hab_tipo = hab_tipo;
    }

    public double getHab_precio() {
        return hab_precio;
    }

    public void setHab_precio(double hab_precio) {
        this.hab_precio = hab_precio;
    }

    public String getHab_estado() {
        return hab_estado;
    }

    public void setHab_estado(String hab_estado) {
        this.hab_estado = hab_estado;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSimple() {
        return simple;
    }

    public void setSimple(double simple) {
        this.simple = simple;
    }

    public double getDoble() {
        return doble;
    }

    public void setDoble(double doble) {
        this.doble = doble;
    }

    public double getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(double matrimonial) {
        this.matrimonial = matrimonial;
    }
       
}
