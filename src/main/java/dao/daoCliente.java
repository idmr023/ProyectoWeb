package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import util.MySQLConexion;

public class daoCliente {
    
    public String nom_cli(String nombre) {
        String c = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "SELECT cli_nombre FROM clientes WHERE cli_nombre =?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                // Ahora, simplemente obtenemos el nombre del cliente como String
                c = rs.getString("cli_nombre");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    //PARA OBTENER LA LISTA DE CLIENTES
    public List<Cliente> listarCli() {
        List<Cliente> lista = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from clientes";
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
                c.setUrl_foto(rs.getString(6));
                
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    //PARA AGREGAR UN CLIENTE
    public void agregarCli(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
                
        try {
            String sql = "insert into clientes values(?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getCli_dni());
            st.setString(2, c.getApellido());
            st.setString(3, c.getNombre());
            st.setString(4, c.getSexo());
            st.setString(5, c.getCelular());
            st.setString(6, c.getUrl_foto());
            
            int filasAfectadas = st.executeUpdate();
            if (filasAfectadas == 0) {
                throw new RuntimeException("No se pudo insertar el cliente");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al agregar cliente", ex);
        }
    }

    //PARA MODIFICAR UN CLIENTE
    public void modificarCli(Cliente c) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update clientes set cli_apellido=?,cli_nombre=?,cli_sexo=?,cli_celular=? where cli_dni=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getApellido());
            st.setString(2, c.getNombre());
            st.setString(3, c.getSexo());
            st.setString(4, c.getCelular());
            st.setString(5, c.getCli_dni());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //PASAR NRO DE DNI CLIENTE 
    public Cliente consultaCli(int nro) {
        Connection cn = MySQLConexion.getConexion(); // nos conectamos con MySQL
        Cliente c = null; // creamos una búsqueda vacía
        String sql = "SELECT cli_dni, cli_apellido, cli_nombre, cli_sexo, cli_celular FROM clientes WHERE cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);// preparamos el SQL
            st.setInt(1, nro);
            // ResultSet, entra fila por fila para poder lograr leer los atributos
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    //PARA OBTENER UN CLIENTE POR DNI 
    //USAR ESTE METODO PORQUE EL DNI ES STRING Y ES EL METODO QUE SE USA PARA COMPROBAR SI UN CLIENTE YA ESTA REGISTRADO AL REGISTRAR ALQUILER NUEVO
    public Cliente buscarCli(String dni) {
        Cliente c = null;
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "select * from clientes where cli_dni=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setCli_dni(rs.getString(1));
                c.setApellido(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setSexo(rs.getString(4));
                c.setCelular(rs.getString(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }

    //ELIMINAR POR NRO DE DNI DE CLIENTE
    public void eliminarCli(int nro) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "delete from clientes where cli_dni=?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);

            st.setInt(1, nro);

            st.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //PARA FILTRAR POR DNI DE  CLIENTE
    public List<Cliente> flitrarCli(String id) {
        List<Cliente> lis = new ArrayList<>();
        try (Connection cn = MySQLConexion.getConexion(); PreparedStatement st = cn.prepareStatement("SELECT cli_dni, cli_apellido, cli_nombre, cli_sexo, cli_celular FROM clientes WHERE cli_dni LIKE ?");) {
            st.setString(1, id + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setCli_dni(rs.getString(1));
                    c.setApellido(rs.getString(2));
                    c.setNombre(rs.getString(3));
                    c.setSexo(rs.getString(4));
                    c.setCelular(rs.getString(5));

                    lis.add(c);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Considera manejar la excepción de una manera más apropiada aquí
        }
        return lis;
    }
    
    
    public Object modificarCli(String nro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}