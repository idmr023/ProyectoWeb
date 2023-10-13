package modelo;

public class Empleado extends Persona {

    private String emp_codigo;
    private String emp_cargo;

    public String getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(String emp_codigo) {
        this.emp_codigo = emp_codigo;
    }   

    public String getEmp_cargo() {
        return emp_cargo;
    }

    public void setEmp_cargo(String emp_cargo) {
        this.emp_cargo = emp_cargo;
    }
    
}
