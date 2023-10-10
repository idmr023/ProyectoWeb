package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import util.MySQLConexion;

public class Negocio {

    Cliente c = new Cliente();

    //agrega un cliente nuevo
    public void adicionCli(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "insert into clientes values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, c.getCli_dni());
            st.setString(2, c.getCli_nombre());
            st.setString(3, c.getCli_apellido());
            st.setString(4, c.getCli_genero());
            st.setInt(5, c.getCli_celular());
            st.setInt(6, c.getCli_num_dias());
            st.setDate(7, c.getCli_fech_reg());
            st.setString(8, c.getCli_tipo_habitacion());

            st.execute();

        } catch (Exception e) {
        }
    }

    //muestra toda la lista clientes
    public List<Cliente> listadoCliente() {
        Connection cn = MySQLConexion.getConexion();
        List<Cliente> lista = new ArrayList<>();
        String sql = "select cli_dni, cli_nombre, cli_apellido, cli_sexo, cli_celular, cli_num_dias, cli_fech_reg, cli_tipo_habitacion from clientes";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_dni(rs.getInt(1));
                c.setCli_nombre(rs.getString(2));
                c.setCli_apellido(rs.getString(3));
                c.setCli_genero(rs.getString(4));
                c.setCli_celular(rs.getInt(5));
                c.setCli_num_dias(rs.getInt(6));
                c.setCli_fech_reg(rs.getDate(7));
                c.setCli_tipo_habitacion(rs.getString(8));

                // Agregar el objeto Cliente a la lista
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //modifica teniendo el nro de Dni
    public void modificaCliente(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "update clientes set  cli_nombre=?, cli_apellido=?, cli_sexo=?, cli_celular=?, cli_num_dias=?, cli_fech_reg=?, cli_tipo_habitacion=? where cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);

            st.setString(1, c.getCli_nombre());
            st.setString(2, c.getCli_apellido());
            st.setString(3, c.getCli_genero());
            st.setInt(4, c.getCli_celular());
            st.setInt(5, c.getCli_num_dias());
            st.setDate(6, c.getCli_fech_reg());
            st.setString(7, c.getCli_tipo_habitacion());
            st.setInt(8, c.getCli_dni());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //consulta pasando un numero de DNI de cliente

    public Cliente consultaCli(int nro) {
        Connection cn = MySQLConexion.getConexion(); // nos conectamos con MySQL
        Cliente c = null; // creamos una búsqueda vacía
        String sql = "SELECT cli_dni, cli_nombre, cli_apellido, cli_sexo, cli_celular, cli_num_dias, cli_fech_reg, cli_tipo_habitacion FROM clientes WHERE cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);// preparamos el SQL
            st.setInt(1, nro);
            // ResultSet, entra fila por fila para poder lograr leer los atributos
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setCli_dni(rs.getInt(1));
                c.setCli_nombre(rs.getString(2));
                c.setCli_apellido(rs.getString(3));
                c.setCli_genero(rs.getString(4));
                c.setCli_celular(rs.getInt(5));
                c.setCli_num_dias(rs.getInt(6));
                c.setCli_fech_reg(rs.getDate(7));
                c.setCli_tipo_habitacion(rs.getString(8));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }

    //anulacion x nro de dni
    public void deletCli(int nro) {
        Connection cn = MySQLConexion.getConexion(); //nos conectamos con mysql
        String sql = "delete from clientes where cli_dni=?"; //colocamos la cantidad de valores que queremos pasar
        try {
            PreparedStatement st = cn.prepareStatement(sql);//preparamos el sql

            //enlazamos los atributos con cada ?
            st.setInt(1, nro);
            //metodo para insertar los valores en la base de datos 
            st.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //filtra alumno x apellido
public List<Cliente> filCli(String id) {
    List<Cliente> lis = new ArrayList<>();
    try (Connection cn = MySQLConexion.getConexion();
         PreparedStatement st = cn.prepareStatement("SELECT cli_dni, cli_nombre, cli_apellido, cli_sexo, cli_celular, cli_num_dias, cli_fech_reg, cli_tipo_habitacion FROM clientes WHERE cli_nombre LIKE ?");
    ) {
        st.setString(1, id + "%");
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_dni(rs.getInt(1));
                c.setCli_nombre(rs.getString(2));
                c.setCli_apellido(rs.getString(3));
                c.setCli_genero(rs.getString(4));
                c.setCli_celular(rs.getInt(5));
                c.setCli_num_dias(rs.getInt(6));
                c.setCli_fech_reg(rs.getDate(7));
                c.setCli_tipo_habitacion(rs.getString(8));
                lis.add(c);
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        // Considera manejar la excepción de una manera más apropiada aquí
    }
    return lis;
}


    /*Terrmina clientes*/
    public Cliente listado_fecha(Date fecha) {
        Connection cn = MySQLConexion.getConexion();
        Cliente c = new Cliente();
        String sql = "select cli_dni,  cli_nombre, cli_apellido, cli_sexo, cli_celular, cli_num_dias, cli_fech_reg, cli_tipo_habitacion where cli_fech_reg=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setDate(1, fecha);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c.setCli_dni(rs.getInt(1));
                c.setCli_nombre(rs.getString(2));
                c.setCli_apellido(rs.getString(3));
                c.setCli_genero(rs.getString(4));
                c.setCli_celular(rs.getInt(5));
                c.setCli_num_dias(rs.getInt(6));
                c.setCli_fech_reg(rs.getDate(7));
                c.setCli_tipo_habitacion(rs.getString(8));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    public List<habitacion> LisVenta(int an){
        List<habitacion> lis=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
         String sql="{call spventa(?)}";   
         CallableStatement st=cn.prepareCall(sql);
         st.setInt(1, an);
         ResultSet rs=st.executeQuery();
         while(rs.next()){
           habitacion p=new habitacion();
           p.setMes(rs.getInt(1));
           p.setTotal(rs.getDouble(2));
           lis.add(p);
         }
        }catch(Exception ex){
          ex.printStackTrace();
        }
        return lis;   
       }
}