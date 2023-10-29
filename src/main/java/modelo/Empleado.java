package modelo;

public class Empleado extends Persona {

    private String emp_correo;
    private String cargo;
    private String pswd;
    private String Emp_codigo;

    public Empleado() {
    }

    public Empleado(String emp_correo, String pswd) {
        this.emp_correo = emp_correo;
        this.pswd = pswd;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getEmp_correo() {
        return emp_correo;
    }

    public void setEmp_correo(String emp_correo) {
        this.emp_correo = emp_correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmp_codigo() {
        return Emp_codigo;
    }

    public void setEmp_codigo(String Emp_codigo) {
        this.Emp_codigo = Emp_codigo;
    }
  
    
}
