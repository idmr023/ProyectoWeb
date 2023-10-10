package modelo;

import java.sql.Date;

public class Cliente {

    private int cli_dni;
    private String cli_nombre;
    private String cli_apellido;
    private String cli_genero;
    private int cli_celular;
    private String cli_tipo_habitacion;
    private int cli_num_dias;
    private Date cli_fech_reg;

    public int getCli_num_dias() {
        return cli_num_dias;
    }

    public void setCli_num_dias(int cli_num_dias) {
        this.cli_num_dias = cli_num_dias;
    }

    public Date getCli_fech_reg() {
        return cli_fech_reg;
    }

    public void setCli_fech_reg(Date cli_fech_reg) {
        this.cli_fech_reg = cli_fech_reg;
    }

    public int getCli_dni() {
        return cli_dni;
    }

    public void setCli_dni(int cli_dni) {
        this.cli_dni = cli_dni;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public String getCli_genero() {
        return cli_genero;
    }

    public void setCli_genero(String cli_genero) {
        this.cli_genero = cli_genero;
    }

    public int getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(int cli_celular) {
        this.cli_celular = cli_celular;
    }

    public String getCli_tipo_habitacion() {
        return cli_tipo_habitacion;
    }

    public void setCli_tipo_habitacion(String cli_tipo_habitacion) {
        this.cli_tipo_habitacion = cli_tipo_habitacion;
    }

}