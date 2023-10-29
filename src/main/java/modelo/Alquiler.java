package modelo;

public class Alquiler extends habitacion {
    private String alq_codigo;
    private String cli_dni;
    private String alq_fechaIngreso;
    private String alq_fechaSalida;
    private String emp_codigo;
    private String alq_estado;

    public String getAlq_codigo() {
        return alq_codigo;
    }

    public void setAlq_codigo(String alq_codigo) {
        this.alq_codigo = alq_codigo;
    }

    public String getCli_dni() {
        return cli_dni;
    }

    public void setCli_dni(String cli_dni) {
        this.cli_dni = cli_dni;
    }

    public String getAlq_fechaIngreso() {
        return alq_fechaIngreso;
    }

    public void setAlq_fechaIngreso(String alq_fechaIngreso) {
        this.alq_fechaIngreso = alq_fechaIngreso;
    }

    public String getAlq_fechaSalida() {
        return alq_fechaSalida;
    }

    public void setAlq_fechaSalida(String alq_fechaSalida) {
        this.alq_fechaSalida = alq_fechaSalida;
    }

    public String getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(String emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getAlq_estado() {
        return alq_estado;
    }

    public void setAlq_estado(String alq_estado) {
        this.alq_estado = alq_estado;
    }    
    
}
